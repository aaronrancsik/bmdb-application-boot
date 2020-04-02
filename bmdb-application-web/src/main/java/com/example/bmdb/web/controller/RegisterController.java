package com.example.bmdb.web.controller;

import com.example.bmdb.models.User;
import com.example.bmdb.services.user.UserService;
import com.example.bmdb.services.errors.EmailExistException;
import com.example.bmdb.services.auth.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
public class RegisterController {

    UserService userService;
    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Inject
    private UserValidator userValidator;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        try {
            userService.save(userForm);
        } catch (EmailExistException e) {
            return "register";
        }
        return "redirect:login";
    }
}
