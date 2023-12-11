package com.codeup.codeupspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/home") //this tells spring to listen to a get request, which is /hello
    @ResponseBody
    public String hello() {
        return "This is the landing page!"; //whatever function is returned will be used by the requester response body
    }

}
