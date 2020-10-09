package com.repository;

import com.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TopicRepositoryHibernateImpl implements TopicRepository {

    private final SessionFactory sessionFactory;

    public TopicRepositoryHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Topic topic) {
        sessionFactory.getCurrentSession().save(topic);
    }

    @Override
    public void update(Topic topic) {
        sessionFactory.getCurrentSession().update(topic);
    }

    @Override
    public Topic get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("from Topic where topicId=:id", Topic.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Topic> getAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {
        return null;
    }

    @Override
    public void delete(Topic topic) {
        return null;
    }
}
