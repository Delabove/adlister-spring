package com.codeup.blogreview.controllers;

import com.codeup.blogreview.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String showLoginForm(){
        return "users/login";
    }

    @PostMapping("/login")
    public String saveUser(@ModelAttribute User user){

        return "redirect:/posts";
    }


}
