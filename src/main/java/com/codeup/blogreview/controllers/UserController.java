package com.codeup.blogreview.controllers;

import com.codeup.blogreview.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private User user;
    private PasswordEncoder passwordEncoder;

    public UserController(User user, PasswordEncoder passwordEncoder)  {

        this.user = user;
        this.passwordEncoder = passswordEncoder;

    }


    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.save(user);
        return "redirect:/login";
    }


}
