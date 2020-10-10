/*
@author Andrei Gorevoi
*/
package com.repository.answer;

import com.model.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class AnswerRepositoryImpl implements AnswerRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public AnswerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAnswer(Answer newAnswer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newAnswer);
    }

    @Override
    public void deleteAnswerById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Answer> query = session.createQuery("from Answer where answerid=:id");
        query.setParameter("id",id);
        session.delete(query.getSingleResult());

    }

    @Override
    public void updateAnswer(Answer updatedAnswer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(updatedAnswer);
    }

    @Override
    public Answer findAnswerById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Answer> query = session.createQuery("from Answer where answerid=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public List<Answer> findAllAnswers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Answer> query = session.createQuery("from Answer");
        return query.getResultList();
    }

    @Override
    public List<Answer> findAllAnswersByQuestionId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Answer> query = session.createQuery("from Answer where questionid=:id");
        query.setParameter("id",id);
        return query.getResultList();
    }
}
