package com.example.myrestapp.repository;

import com.example.myrestapp.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Repository
public class RoleDaoImp implements RoleDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getById(int roleId) {
        TypedQuery <Role> query = entityManager.createQuery("select r from Role r where r.id = :role_id", Role.class)
                .setParameter("role_id", roleId);
        return query.getSingleResult();
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Set<Role> findRoles(List<Integer> roles) {
        TypedQuery<Role> foundedRole = entityManager.createQuery("select r from Role r where r.id in :role", Role.class);
        foundedRole.setParameter("role", roles);
        return new HashSet<>(foundedRole.getResultList());
    }
}
