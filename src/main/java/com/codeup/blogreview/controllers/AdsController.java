package com.codeup.blogreview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdsController {
    @GetMapping("/ads/{id}")
    @ResponseBody
    public String showAd(@PathVariable long id){
        return "Show ad id: " + id;
    }
}
