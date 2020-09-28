/*
@author Andrei Gorevoi
*/
package com.repository.literature;

import com.model.Literature;
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
public class LiteratureRepositoryImpl implements LiteratureRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public LiteratureRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addLiterature(Literature newLiterature) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newLiterature);
    }

    @Override
    public void deleteLiteratureById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Literature> query = session.createQuery("from Literature where literatureid=:id");
        query.setParameter("id",id);
        session.delete(query.getSingleResult());

    }

    @Override
    public void updateLiterature(Literature updatedLiterature) {
        Session session = sessionFactory.getCurrentSession();
        session.update(updatedLiterature);
    }

    @Override
    public Literature findLiteratureById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Literature> query = session.createQuery("from Literature where literatureid=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public List<Literature> findAllLiterature() {
        Session session = sessionFactory.getCurrentSession();
        Query<Literature> query = session.createQuery("from Literature");
        return query.getResultList();
    }

    @Override
    public List<Literature> findAllLiteratureByQuestionId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Literature> query = session.createQuery("from Literature where questionid=:id");
        query.setParameter("id",id);
        return query.getResultList();
    }
}
