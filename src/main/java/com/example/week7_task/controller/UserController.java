package com.example.week7_task.controller;

import com.example.week7_task.dto.LoginDTO;
import com.example.week7_task.dto.UserDTO;
import com.example.week7_task.model.Users;
import com.example.week7_task.services.UserServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/user")
public class UserController {
    @Autowired
    UserServices userServices;
    @GetMapping("/user/login")
    public ModelAndView login(){
       return new ModelAndView("login").addObject("loginDto",new LoginDTO());

    }
    @GetMapping("/user/signup")
    public ModelAndView signup(){
        return new ModelAndView("signup").addObject("user",new Users());
    }
    @PostMapping("/user/save_user")
    public String saveUser(Users users, HttpSession session){
        System.out.println(users);
        userServices.save(users,session);

        return "redirect:/user/login";
    }
    @PostMapping("/user/login")
    public String auth(LoginDTO loginDTO,HttpSession session) {
        if(userServices.auth(loginDTO,session)){
            session.setAttribute("login_status","Successfull");
            return "redirect:/posts/home";
        }
        session.setAttribute("login_status","Invalid login credentials");
        return "redirect:/user/login";
    }
}
