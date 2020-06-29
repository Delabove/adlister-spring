package com.codeup.blogreview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }
//
//    @GetMapping("/")
//    @ResponseBody
//    public String index() {
//        return "Welcome to my blog!";
//    }

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


//    views

    @GetMapping("/hello/{name}")

    public String sayHello(@PathVariable String name, Model model) {
        return "hello";
    }

    @GetMapping("/hello-list")
    public String helloList(Model model){
       List<String> names = new ArrayList<>();
       names.add("DeLayne");
       names.add("Jacques");
        names.add("Chuck");
        names.add("Estaban");
        names.add("Tad");
        names.add("Tandy");
        model.addAttribute("names", names);
        return "hello-list";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }



}
