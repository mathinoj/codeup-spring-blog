package com.codeup.codeupspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {
    @GetMapping("/roll")
    public String rollDicePg(){
        return "roll-dice";
    }

    @GetMapping("/guessDice")
    public String takeToGuess(Model model) {
        int rando = (int)(Math.random() * 6) + 1;
        model.addAttribute("numberGuessed", rando);
        return "guessDice";
    }

//    @PostMapping("/guessDice")
//    public String signUp(@RequestParam(name="email") String email, Model model){
//        model.addAttribute("email", email);
//        return "guessDice";
//    }



}
