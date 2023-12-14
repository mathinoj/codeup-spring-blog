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
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
//    private Post post1 = new Post("Post 1", "qewrqwerqwerqwe");
//    private Post post2 = new Post("Post 2", "qewrqwerqwerqwe");
//    private Post post3 = new Post(3, "Post 3", "qewrqwerqwerqwe");
//    private Post post3 = new Post("Post 3", "Posted 3");
    // Arrays.asList(1, 2, 3)
//    private List<Post> posts = new ArrayList<>(List.of(post1, post2, post3));

    private final PostRepository postDao;
    private final UserRepository userDao;

    //this is a PostController constructor. And everytime a PostController gets created a postDao should be part of it
    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }


    @GetMapping({"/", ""})
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postDao.findAll()
        //posts is the key and the value is postDao.findAll() which is a list of posts
        );
        return "/posts/index";
    }

    @GetMapping("/{id}")
    public String getPostDetail(@PathVariable long id,
                                Model model) {
        model.addAttribute("post", postDao.findAll());
        return "/posts/show";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
//        List<User> users = userDao.findAll();
//        users.sort(Comparator.comparing(User::getId));
//        model.addAttribute("users", users);
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        User user = userDao.findUserById(1L);
//        Post post = new Post(title, body);
//        postDao.save(post);
        postDao.save(new Post(title, body, user));
        return "redirect:/posts";
    }
}