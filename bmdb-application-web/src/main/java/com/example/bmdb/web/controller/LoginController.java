package com.example.bmdb.web.controller;

import com.example.bmdb.services.auth.SecurityService;
import com.example.bmdb.view.I18nMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class LoginController {

    @Inject
    private SecurityService securityService;

    private I18nMsg i18nMsg;
    @Inject
    public void setI18nMsg(I18nMsg i18nMsg) {
        this.i18nMsg = i18nMsg;
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", i18nMsg.getMsg("emailOrPassInvalid"));

        if (logout != null)
            model.addAttribute("message", i18nMsg.getMsg("success.logout"));

        return "login";
    }

}