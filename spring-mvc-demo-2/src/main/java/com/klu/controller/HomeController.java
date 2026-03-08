package com.klu.controller;

import com.klu.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    // GET   http://localhost:8080/home    
    @GetMapping("/home")
    @ResponseBody   // Without this, Spring looks for a view
    public String home() {
        return "Welcome to Spring MVC Controller";
    }

    // GET   http://localhost:8081/user-info
    @GetMapping("/user-info")
    @ResponseBody
    public User getUser() {
        return new User(1, "RAMA");
    }
}

