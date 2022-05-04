package com.example.myrestapp.service;


import com.example.myrestapp.model.User;
import com.example.myrestapp.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.Table;
import java.util.List;


@Service ("userEntityServiceImp")
public class UserServiceImp implements UserService{
    private final UserDao userRep;
    @Autowired
    public UserServiceImp(UserDao userRep) {
        this.userRep = userRep;
    }

    @Transactional
    @Override
    public User add(User user) {
        return userRep.add(user);
    }

    @Transactional
    @Override
    public User update(User user, int id) {
        User existingUser = userRep.getUserById(id);
        existingUser.setName(user.getName());
        existingUser.setSecondName(user.getSecondName());
        existingUser.setUsername(user.getUsername());
        existingUser.setRoles(user.getRoles());
        return userRep.add(existingUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userRep.remove(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRep.getAllUsers();
    }

    @Override
    public User getById(int id) {
        return userRep.getUserById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRep.getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }
}
