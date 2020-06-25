package com.codeup.blogreview.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

//    Create a PostController class. This
//    controller should return strings for
//    the following routes that describe
//    what will ultimately be there.

//    method	url	description
//    GET	/posts	posts index page
//    GET	/posts/{id}	view an individual post
//    GET	/posts/create	view the form for creating a post
//    POST	/posts/create	create a new post
//

    @GetMapping("/posts")
    @ResponseBody
    public String postIndex(){
        return "Post Index Page";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String insert(@PathVariable long id){
        return "Post Id : " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewForm(){
        return "Form for Creating a Post";
    }

    @PostMapping("posts/create")
    @ResponseBody
    public String createPost(){
        return "Create a New Post!";
    }


}
