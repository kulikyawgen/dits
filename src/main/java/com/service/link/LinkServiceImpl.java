/*
@author Andrei Gorevoi
*/
package com.service.link;

import com.model.Link;
import com.repository.link.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Link addLink(Link newLink) {
        return linkRepository.save(newLink);
    }

    @Override
    public void deleteLinkById(int id) {
        linkRepository.deleteLinkById(id);
    }

    @Override
    public void updateLink(Link updatedLink) {
        linkRepository.save(updatedLink);
    }

    @Override
    public Link getLinkById(int id) {
        return linkRepository.findLinkById(id);
    }

    @Override
    public List<Link> getAllLink() {
        return linkRepository.findAll();
    }

    @Override
    public List<Link> getAllLinkByLiteratureId(int id) {
        return linkRepository.findAllLinkByLiteratureId(id);
    }
}
