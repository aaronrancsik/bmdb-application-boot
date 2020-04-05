package com.example.bmdb.web.controller;

import com.example.bmdb.models.Review;
import com.example.bmdb.models.User;
import com.example.bmdb.services.auth.UserEmailValidator;
import com.example.bmdb.services.auth.UserNameValidator;
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

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;


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
        User user = getSessionUser();
        model.addAttribute("userForm", user);
        model.addAttribute("reviews", user.getReviews());
        return "home";
    }

    @PostMapping("/")
    public String home(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, HttpServletRequest request, Model model) {

        User user = getSessionUser();
        setReviewsAttribute(model, user.getReviews());
        validateNameIfChanged(userForm, bindingResult, user);

        boolean emailChanged = !user.getEmail().equals(userForm.getEmail());

        if (emailChanged) {
            validateEmail(userForm, bindingResult);
        }

        if (bindingResult.hasErrors()) {
            return "home";
        }

        userService.setUserInfoById(userForm.getEmail(), userForm.getName(), user.getId());

        if (emailChanged) {
            return invalidateSessionAndRedirect(request);
        }

        return "home";
    }

    private void validateEmail(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userEmailValidator.validate(userForm, bindingResult);
    }

    private void validateNameIfChanged(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, User user) {
        if (!user.getName().equals(userForm.getName())) {
            userNameValidator.validate(userForm, bindingResult);
        }
    }

    private void setReviewsAttribute(Model model, Collection<Review> reviews) {
        model.addAttribute("reviews", reviews);
    }

    private User getSessionUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        return userService.findByEmail(userDetail.getUsername());
    }

    private String invalidateSessionAndRedirect(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }


}
