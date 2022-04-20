package com.example.myrestapp.repository;

import com.example.myrestapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRep extends JpaRepository <Role, Integer> {
}
