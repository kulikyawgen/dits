/*
@author Andrei Gorevoi
*/
package com.repository.topic;

import com.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TopicRepositoryImpl implements TopicRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public TopicRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTopic(Topic newTopic) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newTopic);
    }

    @Override
    public void deleteTopicById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("from Topic where topicid=:id");
        query.setParameter("id",id);
        session.delete(query.getSingleResult());

    }

    @Override
    public void deleteTopicByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("from Topic where name=:name");
        query.setParameter("name",name);
        session.delete(query.getSingleResult());
    }

    @Override
    public void updateTopic(Topic updatedTopic) {
        Session session = sessionFactory.getCurrentSession();
        session.update(updatedTopic);
    }

    @Override
    public Topic findTopicById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("from Topic where topicid=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public Topic findTopicByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("from Topic where name=:name");
        query.setParameter("name",name);
        return query.getSingleResult();
    }

    @Override
    public List<Topic> findAllTopics() {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("from Topic");
        return query.getResultList();
    }
}
