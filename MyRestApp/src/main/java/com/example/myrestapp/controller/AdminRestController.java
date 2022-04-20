package com.example.myrestapp.controller;

import com.example.myrestapp.model.User;
import com.example.myrestapp.service.RoleService;
import com.example.myrestapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/users")
public class AdminRestController {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public List <User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id_var}")
    public ResponseEntity <User> getUserById (@PathVariable ("id_var") int id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser (@RequestBody User user) {
//        Set<Role> roles = new HashSet<>();
//            if (user.getRoles().contains("1")){
//                roles.add(roleService.getById(1));
//            }
//            if (user.getRoles().contains("2")) {
//                roles.add(roleService.getById(2));
//            }
//        user.setRoles(roles);
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @PutMapping ("/{id_var}")
    public ResponseEntity<User> editUser (@RequestBody User user, @PathVariable ("id_var") int id) {
        return new ResponseEntity<>(userService.update(user, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id_var}")
    public void deleteUser (@PathVariable ("id_var") int id) {
        userService.delete(id);
    }
}
