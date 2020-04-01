package com.example.bmdb.web.controller;

import com.example.bmdb.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;


@Controller
public class HelloController {


    private MediaService mediaService;
    @Inject
    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }


    @RequestMapping({"/", "/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        var allMedia = mediaService.findAll();
        model.addAttribute("name", allMedia.iterator().next().getTitle());
        return "hello";
    }

}
