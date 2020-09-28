/*
@author Andrei Gorevoi
*/
package com.repository.test;

import com.model.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class TestRepositoryImpl implements TestRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public TestRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTest(Test newTest) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newTest);
    }

    @Override
    public void deleteTestById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Test> query = session.createQuery("from Test where testid=:id");
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }

    @Override
    public void deleteTestByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Test> query = session.createQuery("from Test where name=:name");
        query.setParameter("name",name);
        session.delete(query.getSingleResult());
    }

    @Override
    public void updateTest(Test updatedTest) {
        Session session = sessionFactory.getCurrentSession();
        session.update(updatedTest);
    }

    @Override
    public Test findTestById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Test> query = session.createQuery("from Test where testid=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public Test findTestByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Test> query = session.createQuery("from Test where name=:name");
        query.setParameter("name",name);
        return query.getSingleResult();
    }

    @Override
    public List<Test> findAllTests() {
        Session session = sessionFactory.getCurrentSession();
        Query<Test> query = session.createQuery("from Test");
        return query.getResultList();
    }

    @Override
    public List<Test> findAllTestsByTopicId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Test> query = session.createQuery("from Test where topicid=:id");
        query.setParameter("id",id);
        return query.getResultList();
    }
}
