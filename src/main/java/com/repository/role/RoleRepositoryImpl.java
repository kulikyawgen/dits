/*
@author Andrei Gorevoi
*/
package com.repository.role;

import com.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role findRoleByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Role> query = session.createQuery("from Role r where r.name = : name");
        query.setParameter("name",name);
        return query.getSingleResult();
    }

    @Override
    public Role findRoleById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Role> query = session.createQuery("from Role r where r.id = : id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public List<Role> findAllRoles() {
        Session session = sessionFactory.getCurrentSession();
        Query<Role> query = session.createQuery("from Role");
        return query.getResultList();
    }

    @Override
    public Role addRole(String roleName) {
        Role newRole = new Role();
        newRole.setName(roleName);
        Session session = sessionFactory.getCurrentSession();
        return (Role) session.save(newRole);
    }
}
