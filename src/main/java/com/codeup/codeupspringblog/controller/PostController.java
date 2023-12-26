package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.dao.PostRepository;
import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {
//    private Post post1 = new Post(1, "Post 1", "qewrqwerqwerqwe");
//    private Post post2 = new Post(2, "Post 2", "qewrqwerqwerqwe");
//    private Post post3 = new Post(3, "Post 3", "qewrqwerqwerqwe");
//    private List<Post> posts = new ArrayList<>(List.of(post1, post2, post3));

    private final PostRepository postDao;
    //finals mean the values can never be reassigned. Also saves memory.
    private final UserRepository userDao; //this is added to the post controller as a property

    //this is a PostController constructor. And everytime a PostController gets created a postDao should be part of it
    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
        //this sets the repository's in the constructor
    }


    @GetMapping({"/", ""})
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postDao.findAll()
        //posts is the key and the value is postDao.findAll() which is a list of posts
        );
        return "/posts/index";
    }

    @GetMapping({"/{id}", "/{id}"})
    public String getPostDetail(@PathVariable long id,
                                Model model) {
        Post post;
        if(postDao.findById(id).isPresent()){
            post = postDao.findById(id).get();
        }else{
            post = new Post("Post no find.", "");
        }
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
//        List<User> users = userDao.findAll();
//        users.sort(Comparator.comparing(User::getId));
//        model.addAttribute("users", users);
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitPost(
//            @RequestParam(name = "title") String title, @RequestParam(name = "body") String body
            @ModelAttribute Post post
    ) {
//        Post post = new Post(title, body);
        User user = userDao.findUserById(1L);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        Post post;
        if(postDao.findById(id).isPresent()){
            post = postDao.findById(id).get();
        }else{
            post = null;
        }
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@ModelAttribute Post modifiedPost){
        Post oldPost = null;
        Optional<Post> checkPost = postDao.findById(modifiedPost.getId());
        if(checkPost.isPresent()){
            oldPost = checkPost.get();
        }
        if(oldPost != null){
            modifiedPost.setUser(oldPost.getUser());
        }
//        Post oldPost = postDao.findById(modifiedPost.getId()).get();
//        modifiedPost.setUser(oldPost.getUser());
        postDao.save(modifiedPost);
        return "redirect:/posts";
    }
}