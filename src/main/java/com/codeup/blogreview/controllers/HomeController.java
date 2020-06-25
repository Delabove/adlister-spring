package com.codeup.blogreview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
//    Create a HomeController class. This class should have one method with a GetMapping for /. It should return a string that says "This is the landing page!".
//
//    This will eventually be the page that users see when they first visit your page. Later on, when we learn about views, you can swap it out for something more fancy.

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "This is the landing page!";
    }





//    Create a PostController class. This controller should return strings for the following routes that describe what will ultimately be there.
//    method	url	description
//    GET	/posts	posts index page
//    GET	/posts/{id}	view an individual post
//    GET	/posts/create	view the form for creating a post
//    POST	/posts/create	create a new post
//



}
