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
    public void addLink(Link newLink) {
        linkRepository.addLink(newLink);
    }

    @Override
    public void deleteLinkById(Long id) {
        linkRepository.deleteLinkById(id);
    }

    @Override
    public void updateLink(Link updatedLink) {
        linkRepository.updateLink(updatedLink);
    }

    @Override
    public Link getLinkById(Long id) {
        return linkRepository.findLinkById(id);
    }

    @Override
    public List<Link> getAllLink() {
        return linkRepository.findAllLink();
    }

    @Override
    public List<Link> getAllLinkByQuestionId(Long id) {
        return linkRepository.findAllLinkByQuestionId(id);
    }
}
