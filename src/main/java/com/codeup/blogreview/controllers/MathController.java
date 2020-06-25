package com.codeup.blogreview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

//    Create a MathController class.
//    This controller should listen for requests for several routes that correspond to basic arithmetic operations and produce the result of the arithmetic.

//             /add/3/and/4	7
//            /subtract/3/from/10	7
//            /multiply/4/and/5	20
//            /divide/6/by/3	2


    @GetMapping("/add/{num1}/and/{num2}")

    @ResponseBody
    public String add (@PathVariable int num1, @PathVariable int num2){
        return "3 + 4 = " + (num1 + num2);
    }


    @GetMapping("/subtract/{num1}/from/{num2}")

    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
        return "10 - 3 = " + (num2 - num1);
    }


    @GetMapping("/multiply/{num1}/and/{num2}")

    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2){
        return "4 x 5 = " + (num1 * num2);
    }

    @GetMapping("/divide/{num1}/by/{num2}")

    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
        return "6 % 3 = " + (num1 / num2);
    }
}
