package com.example.bmdb.web.controller;

import com.example.bmdb.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;


@Controller
public class HomeController {


    private MediaService mediaService;
    @Inject
    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @RequestMapping({"/"})
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        var allMedia = mediaService.findAll();
        model.addAttribute("name", name);
        model.addAttribute("movie", allMedia.iterator().next().getTitle());
        return "home";
    }


}
