/*
@author Andrei Gorevoi
*/
package com.repository.question;

import com.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class QuestionRepositoryImpl implements QuestionRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public QuestionRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addQuestion(Question newQuestion) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newQuestion);
    }

    @Override
    public void deleteQuestionById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Question> query = session.createQuery("from Question where questionid=:id");
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }

    @Override
    public void updateQuestion(Question updatedQuestion) {
        Session session = sessionFactory.getCurrentSession();
        session.update(updatedQuestion);
    }

    @Override
    public Question findQuestionById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Question> query = session.createQuery("from Question where questionid=:id");
        return query.getSingleResult();
    }

    @Override
    public List<Question> findAllQuestion() {
        Session session = sessionFactory.getCurrentSession();
        Query<Question> query = session.createQuery("from Question");
        return query.getResultList();
    }

    @Override
    public List<Question> findAllTestsByTestId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Question> query = session.createQuery("from Question where testid=:id");
        query.setParameter("id",id);
        return query.getResultList();
    }
}
