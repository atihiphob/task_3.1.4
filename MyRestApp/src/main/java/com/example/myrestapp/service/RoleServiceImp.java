package com.example.myrestapp.service;

import com.example.myrestapp.model.Role;
import com.example.myrestapp.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService{
    private final RoleDao roleDao;
    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getById(int id) {
        return roleDao.getById(id);
    }

    @Override
    public Set<Role> getRoles(List<Integer> roles) {
        Set <Role> rolesSet = new HashSet<>();
        for (int i = 0; i < roles.size(); i++) {
            rolesSet.add(roleDao.getById(roles.get(i)));
        }
        return rolesSet;
    }
}
