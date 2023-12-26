package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.dao.AdDao;
import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Controller
@RequestMapping("/ads")
public class AdController {

    private AdDao adDao;
    private UserRepository userDao;
//    private CategoryDao categoryDao;


//    public AdController(AdDao adDao){
//        this.adDao = adDao;
//    }

    @GetMapping(value = {"", "/"})
    public String adIndex(Model model){
        List<Ad> ads = adDao.findAll();
        model.addAttribute("ads", ads);
        return "/ads/index";
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String showAd(@PathVariable long id,
                         Model model) {
        Ad ad;
        if (adDao.findById(id).isPresent()){
            ad = adDao.findById(id).get();
//            System.out.println(ad);
        } else {
            ad = new Ad("Ad not found", "");
        }
        model.addAttribute("ad", ad);
        return "/ads/show";
    }

    @GetMapping({"/create", "/create/"})
    public String showCreate(Model model) {
//        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("ad", new Ad());
        return "/ads/create";
    }

    @PostMapping({"/create", "/create/"})
    public String doCreate(
//            @RequestParam(name="title") String title,
//            @RequestParam(name = "description") String description
            @ModelAttribute Ad ad
    )
    {
//        Ad ad = new Ad(title, description);
        ad.setUser(userDao.findUserById(1L));
        adDao.save(ad);
        return "redirect:/ads";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        Ad ad;
        if(adDao.findById(id).isPresent()){
            ad = adDao.findById(id).get();
        }else{
            ad = null;
        }
        model.addAttribute("ad", ad);
        return "/ads/edit";
    }

    @PostMapping("/{id}/edit")
    public String editAd(
//            @ModelAttribute Ad ad,
//            @RequestParam long userId
            @ModelAttribute Ad modifiedAd
    )
    {
        Ad oldAd = adDao.findById(modifiedAd.getId()).get();
        modifiedAd.setUser(oldAd.getUser());
        adDao.save(modifiedAd);
//        ad.setUser(userDao.findUserById(userId));
//        adDao.save(ad);
        return "redirect:/ads";
    }

//    @DeleteMapping("/delete/{id}")
@GetMapping("/{id}/delete")
public String deleteAd(@PathVariable("id") long id){
    adDao.deleteById(id);
    return "redirect:/ads";
    }



}