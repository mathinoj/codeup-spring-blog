package com.codeup.codeupspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "This is the landing page!"; //whatever function is returned will be used by the requester response body
    }

    @GetMapping("/home")
    public String welcome(){
        return "home";
    }
}
