package com.codeup.codeupspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    @GetMapping("/home") //this tells spring to listen to a get request, which is /hello
    @ResponseBody
    public String hello() {
        return "This is the landing page!"; //whatever function is returned will be used by the requester response body
    }

    @GetMapping(path = "/add/{numb1}/and/{numb2}", produces = "application/json")
    @ResponseBody
    public String addNumbs(@PathVariable int numb1, @PathVariable int numb2) {
        return "Your numbs added = " + (numb1 + numb2);
    }

    @GetMapping(path = "/subtract/{numb1}/from/{numb2}", produces = "application/json")
    @ResponseBody
    public String subNumbs(@PathVariable int numb1, @PathVariable int numb2) {
        return "Your numbs subtracted = " + (numb2 - numb1);
    }

    @GetMapping(path = "/times/{numb1}/and/{numb2}", produces = "application/json")
    @ResponseBody
    public String subTimes(@PathVariable int numb1, @PathVariable int numb2) {
        return "Your numbs subtracted = " + (numb1 * numb2);
    }

    @GetMapping(path = "/divide/{numb1}/by/{numb2}", produces = "application/json")
    @ResponseBody
    public String subDivide(@PathVariable int numb1, @PathVariable int numb2) {
        return "Your numbs subtracted = " + (numb1 / numb2);
    }
}
