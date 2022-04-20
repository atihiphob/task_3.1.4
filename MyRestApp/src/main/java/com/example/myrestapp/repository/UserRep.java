package com.example.myrestapp.repository;

import com.example.myrestapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository <User, Integer> {
    User getUserByUsername (String username);
}
