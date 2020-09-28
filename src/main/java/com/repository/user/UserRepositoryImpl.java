/*
@author Andrei Gorevoi
*/
package com.repository.user;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
   
   private final SessionFactory sessionFactory;
    
   @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(User newUser) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newUser);
    }

    @Override
    public void updateUser(User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(updatedUser);
    }

    @Override
    public User findUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where login=:login");
        query.setParameter("login",login);
        return query.getSingleResult();
    }

    @Override
    public User findUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where userid=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public List<User> findAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public boolean deleteUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where userid=:id");
        session.delete(query.setParameter("id",id));
        return true;
    }

    @Override
    public boolean deleteUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where login=:login");
        session.delete(query.setParameter("login",login));
        return true;
    }
}
