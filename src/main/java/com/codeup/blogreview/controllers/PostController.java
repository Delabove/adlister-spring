package com.codeup.blogreview.controllers;


import com.codeup.blogreview.DAO.PostRepository;
import com.codeup.blogreview.DAO.UserRepository;
import com.codeup.blogreview.models.Post;
import com.codeup.blogreview.models.User;
import com.codeup.blogreview.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@Controller
public class PostController {
    private PostRepository postsDao;
    private UserRepository usersDao;
    private final EmailService emailService;



    public PostController(PostRepository postsRepository, UserRepository usersRepository, EmailService emailService){

        this.postsDao = postsRepository;
        this.usersDao = usersRepository;
        this.emailService = emailService;

    }

    @GetMapping("/posts")
    public String postIndex(Model model){
//       Post firstAd = postsDao.findFirstByTitle("Covid");
//        System.out.println("firstAd.getId() = " + firstAd.getId());

        List<Post> postList = postsDao.findAll();
        model.addAttribute("posts", postList);
        return "/posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model){
        Post post = postsDao.getOne(id);
        model.addAttribute("postId", id);
        model.addAttribute("post", post);
        return "/posts/show";
    }


    @GetMapping("/posts/create")

    public String viewForm(Model viewModel){
        viewModel.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post savedPost){

        User newUser = usersDao.getOne(1L);
        System.out.println(newUser.getId());
        savedPost.setOwner(newUser);
        Post savedTestPost = postsDao.save(savedPost);
        emailService.prepareAndSend(savedPost, "A new post has been created.","A new post has been created with the id of " + savedPost.getId());
        return "redirect:/posts/" + savedPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id){
        Post postToEdit = postsDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")

    public String editPost(@ModelAttribute Post postToEdit){
       User currentUser = usersDao.getOne(1L);
       postToEdit.setOwner(currentUser);
       postsDao.save(postToEdit);
        return "redirect:/posts/" + postToEdit.getId();
    }


    @PostMapping("/posts/{id}/delete")

    public String destroy(@PathVariable long id){
        postsDao.deleteById(id);
        return "redirect:/posts/";

    }



}
