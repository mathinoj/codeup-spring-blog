package com.codeup.codeupspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String viewAll() {
        return "Index Page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewOnePost(@PathVariable int id) {
        return "Single Post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String editPostForm() {
        return "Post Form";
    }

    @PostMapping("/posts/create")
//    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create Post";
    }
}
