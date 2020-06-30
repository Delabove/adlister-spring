package com.codeup.blogreview.controllers;


import com.codeup.blogreview.DAO.PostRepository;
import com.codeup.blogreview.DAO.UserRepository;
import com.codeup.blogreview.models.Post;
import com.codeup.blogreview.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@Controller
public class PostController {
    private PostRepository postsDao;
    private UserRepository usersDao;

    public PostController(PostRepository postsRepository, UserRepository usersRepository){

        postsDao = postsRepository;
        usersDao = usersRepository;

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

    public String viewForm(Model viewModel){
        return "View form";
    }

    @PostMapping("/posts/create")

    public String createPost(){

        User newUser = usersDao.getOne(1L);
        Post newPost = new Post("Health", "Wear your mask!", newUser);
        postsDao.save(newPost);
        return "Create a New Post!";
    }

    @PostMapping("/posts/{id}/edit")

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

    public String destroy(@PathVariable long id){
        postsDao.deleteById(id);
        return "post deleted";
    }



}
