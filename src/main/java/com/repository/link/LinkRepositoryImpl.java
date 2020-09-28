/*
@author Andrei Gorevoi
*/
package com.repository.link;

import com.model.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class LinkRepositoryImpl implements LinkRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public LinkRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addLink(Link newLink) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newLink);
    }

    @Override
    public void deleteLinkById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Link> query = session.createQuery("from Link where linkid=:id");
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }

    @Override
    public void updateLink(Link updatedLink) {
        Session session = sessionFactory.getCurrentSession();
        session.update(updatedLink);
    }

    @Override
    public Link findLinkById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Link> query = session.createQuery("from Link where linkid=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public List<Link> findAllLink() {
        Session session = sessionFactory.getCurrentSession();
        Query<Link> query = session.createQuery("from Link ");
        return query.getResultList();
    }

    @Override
    public List<Link> findAllLinkByQuestionId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Link> query = session.createQuery("from Link where literatureid =:id");
        query.setParameter("id",id);
        return query.getResultList();
    }
}
