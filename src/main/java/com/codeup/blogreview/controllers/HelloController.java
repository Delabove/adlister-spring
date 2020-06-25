package com.codeup.blogreview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome to my blog!";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @PostMapping("/ads/create")
        @ResponseBody
        public String insert(){
            return "Posted";
    }

}
