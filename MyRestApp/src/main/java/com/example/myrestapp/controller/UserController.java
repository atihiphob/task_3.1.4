package com.example.myrestapp.controller;

import com.example.myrestapp.model.User;
import com.example.myrestapp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping ("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User getAuthorisedUser (Principal principal) {
        return userService.findByUsername(principal.getName());
    }
}
