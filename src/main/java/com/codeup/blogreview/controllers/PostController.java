package com.codeup.blogreview.controllers;


import com.codeup.blogreview.DAO.PostRepository;
import com.codeup.blogreview.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@Controller
public class PostController {
    private PostRepository postsDao;

    public PostController(PostRepository postsRepository){
        postsDao = postsRepository;
    }

    @GetMapping("/posts")
    public String postIndex(Model model){

        List<Post> postList = postsDao.findAll();

        model.addAttribute("posts", postList);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model){
        Post post = postsDao.getOne(id);
        model.addAttribute("postId", id);
        model.addAttribute("post", post);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String viewForm(){
        return "posts/create";
    }

    @PostMapping("posts/create")
    @ResponseBody
    public String createPost(){

        Post newPost = new Post("Health", "Wear your mask!");
        postsDao.save(newPost);
        return "Create a New Post!";
    }

    @PostMapping("posts/{id}/edit")
    @ResponseBody
    public String update(@PathVariable long id){
        //find a post
        Post foundPost = postsDao.getOne(id); //select * from ads where id =?
        //edit the post
        foundPost.setTitle("Xbox series X");
        //save the changes
        postsDao.save(foundPost); //update posts set title = ? where id =?
        return "posted edited";
    }


    @PostMapping("/posts/{id}/delete")
    @ResponseBody
    public String destroy(@PathVariable long id){
        postsDao.deleteById(id);
        return "post deleted";
    }



}
