package com.example.bmdb.web.controller;

import com.example.bmdb.models.Review;
import com.example.bmdb.models.User;
import com.example.bmdb.services.*;
import com.example.bmdb.services.auth.UserEmailValidator;
import com.example.bmdb.services.auth.UserNameEmailValidator;
import com.example.bmdb.services.auth.UserNameValidator;
import com.example.bmdb.services.auth.UserValidator;
import com.example.bmdb.services.errors.EmailExistException;
import com.example.bmdb.services.user.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;


@Controller
public class HomeController {

    private AuthenticationManager authenticationManager;
    @Inject
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    private UserService userService;
    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserNameValidator userNameValidator;
    @Inject
    public void setUserNameValidator(UserNameValidator userNameValidator) {
        this.userNameValidator = userNameValidator;
    }

    private UserEmailValidator userEmailValidator;
    @Inject
    public void setUserEmailValidator(UserEmailValidator userEmailValidator) {
        this.userEmailValidator = userEmailValidator;
    }

    @RequestMapping({"/"})
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(userDetail.getUsername());
        model.addAttribute("userForm", user);
        model.addAttribute("reviews", user.getReviews() );
        return "home";
    }

    @PostMapping("/")
    public String home(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, HttpServletRequest request, Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(userDetail.getUsername());
        model.addAttribute("reviews", user.getReviews() );
        
        if(!user.getName().equals(userForm.getName())){
            userNameValidator.validate(userForm, bindingResult);
        }

        boolean emailModified = !user.getEmail().equals(userForm.getEmail());

        if(emailModified){
            userEmailValidator.validate(userForm, bindingResult);
        }



        if (bindingResult.hasErrors()) {
            return "home";
        }

        userService.setUserInfoById(userForm.getEmail(),userForm.getName(),user.getId());



        if(emailModified){
            HttpSession session= request.getSession(false);
            SecurityContextHolder.clearContext();
            if(session != null) {
                session.invalidate();
            }
            return "redirect:/login";
        }


        return "home";
    }


}
