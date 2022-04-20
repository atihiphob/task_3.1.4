package com.example.myrestapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyViewController {
    @GetMapping("/admin")
    public String admin () {
        return "admin";
    }

    @GetMapping("/user")
    public String user () {
        return "user";
    }
}
