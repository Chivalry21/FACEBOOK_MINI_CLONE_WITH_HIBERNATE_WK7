package com.example.week7_task.controller;

import com.example.week7_task.model.Posts;
import com.example.week7_task.services.PostServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/posts")
public class PostController {

    @Autowired
    PostServices postServices;

    @GetMapping("/posts/home")
    public ModelAndView post(HttpSession session){
        return new ModelAndView("home").addObject("postDto",new Posts());
    }

    public String save(Posts posts, HttpSession session){
        postServices. save(posts, session);
        return "redirect:/posts/home";
    }



}
