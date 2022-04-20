package com.example.myrestapp.service;

import com.example.myrestapp.model.Role;

import java.util.Set;

public interface RoleService {
    void add (Role role);
    Role getById (int id);
    Set<Role> getRoles(int [] ides);
}
