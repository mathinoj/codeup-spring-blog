package com.codeup.codeupspringblog.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller// this defines that our class is a controller
public class HelloController {
    @GetMapping("/hello") //this tells spring to listen to a get request, which is /hello
    @ResponseBody
    public String hello() {
        return "Hello from Spring!"; //whatever function is returned will be used by the requester response body
    }


    @GetMapping(path = "/hello-msg", produces = "application/json") //hello/MSG - hello-msg is the path variable
    @ResponseBody
    public String helloMessage() {
        return String.format("Hello from Spring, Matthias, this JSON! %s", LocalDateTime.now());
    }

//    @GetMapping(path = "/hello-msg/{personName}", produces = "application/json")
//    @ResponseBody
//    public String helloMessageName(@PathVariable String personName) {
//        return String.format("Hello from Spring, %s, this JSON! %s", personName, LocalDateTime.now());
//    }
@GetMapping("/hello/{name}")
public String sayHello(@PathVariable String name, Model model) {
    model.addAttribute("name", name);
    return "hello";
}


    private int counter = 0;
    @GetMapping(path = "/counter/{counterInit}")
    @ResponseBody
    public String initCounter(@PathVariable int counterInit) {
        counter = counterInit;
        return "Counter reset to " +counterInit;
     }

    @GetMapping(path = "/increment")
    @ResponseBody
    public String incrementCounter() {
        counter++;
        return "Counter is now " +counter;
    }

}
