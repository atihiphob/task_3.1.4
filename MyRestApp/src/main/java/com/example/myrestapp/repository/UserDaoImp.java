package com.example.myrestapp.repository;

import com.example.myrestapp.model.Role;
import com.example.myrestapp.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao{

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User add(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
        return user;
    }

    @Override
    public void update(User user, Set<Role> roles) {
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        entityManager.merge(user);
    }

    @Override
    public void remove(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u join fetch u.roles r where u.username = :username", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
