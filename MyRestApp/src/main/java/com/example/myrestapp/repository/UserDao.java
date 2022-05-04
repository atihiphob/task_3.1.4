package com.example.myrestapp.repository;

import com.example.myrestapp.model.Role;
import com.example.myrestapp.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    User add (User user);
    void update(User user, Set<Role> roles);
    void remove(int id);
    User getUserById (int id);
    List<User> getAllUsers();
    User getUserByUsername (String username);
}
