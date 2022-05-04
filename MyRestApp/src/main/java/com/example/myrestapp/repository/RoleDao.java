package com.example.myrestapp.repository;

import com.example.myrestapp.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    void add (Role role);
    Role getById (int roleId);
    List<Role> getAllRoles();
    Set<Role> findRoles (List <Integer> roles);
}
