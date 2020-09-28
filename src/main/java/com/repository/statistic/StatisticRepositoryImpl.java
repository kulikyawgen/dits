/*
@author Andrei Gorevoi
*/
package com.repository.statistic;

import com.model.Statistic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StatisticRepositoryImpl implements StatisticRepository {

    private  final SessionFactory sessionFactory;

    @Autowired
    public StatisticRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Statistic addStatistic(Statistic newStatistic) {
        Session session = sessionFactory.getCurrentSession();
        return (Statistic) session.save(newStatistic);
    }

    @Override
    public List<Statistic> findAllStatistics() {
        Session session = sessionFactory.getCurrentSession();
        Query<Statistic> query = session.createQuery("from Statistic ");
        return query.getResultList();
    }

    @Override
    public List<Statistic> findAllStatisticsByUserId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Statistic> query = session.createQuery("from Statistic where userid=: id");
        query.setParameter("id",id);
        return query.getResultList();
    }

    @Override
    public Statistic findStatisticByTopicByQuestionId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Statistic> query = session.createQuery("from Statistic where questionid=: id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public boolean deleteStatisticById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Statistic> query = session.createQuery("from Statistic where statisticid=:id");
        Query<Statistic> statistic = query.setParameter("id", id);
        session.remove(statistic);
        return true;
    }

    @Override
    public void updateStatistic(Statistic updatedStatistic) {
        Session session = sessionFactory.getCurrentSession();
        session.update(updatedStatistic);
    }
}
