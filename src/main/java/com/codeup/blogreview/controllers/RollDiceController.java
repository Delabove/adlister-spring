package com.codeup.blogreview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class RollDiceController {

@GetMapping("/roll-dice/{guess}")

public String usersGuess(@PathVariable int guess, Model model){


//    random number
int random = (int) (Math.random() * 6 + 1);

    model.addAttribute("guess", guess);
    model.addAttribute("random", random);
    model.addAttribute("isCorrectGuess", random == guess);

    return "roll-dice";

}


    @GetMapping("/roll-dice")

    public String showDice(){
        return "roll-dice";
    }


}
