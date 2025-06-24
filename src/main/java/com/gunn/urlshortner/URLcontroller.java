package com.gunn.urlshortner;

import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class URLcontroller {
    public final Repo repo;

    public URLcontroller(Repo repo) {
        this.repo = repo;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/get/{id}")
    public String redirect(@PathVariable("id") String id) {
        String result = repo.urls.get(id);
        if (result == null) return "redirect:/?error=true";
        return "redirect:" + result;
    }

    @PostMapping("/shorten")
    public String shorten(@RequestParam("url") String url, Model model) {
        String result = UUID.randomUUID().toString().substring(0, 5);
        repo.urls.put(result, url);
        model.addAttribute("shortened", "http://localhost:8080/get/" + result);
        return "home";
    }
}