package com.example.myrestapp.service;

import com.example.myrestapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User add (User user);
    User update (User user, int id);
    void delete (int id);
    List<User> getAllUsers();
    User getById (int id);
    User findByUsername (String username);
}
