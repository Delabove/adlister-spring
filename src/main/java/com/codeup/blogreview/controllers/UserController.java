package com.codeup.blogreview.controllers;

import com.codeup.blogreview.DAO.UserRepository;
import com.codeup.blogreview.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userdao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userdao, PasswordEncoder passwordEncoder)  {

        this.userdao = userdao;
        this.passwordEncoder =  passwordEncoder;

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
        userdao.save(user);
        return "redirect:/login";
    }

}
