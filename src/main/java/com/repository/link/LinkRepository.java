/*
@author Andrei Gorevoi
*/
package com.repository.link;

import com.model.Link;

import java.util.List;

public interface LinkRepository {
    void addLink(Link newLink);
    void deleteLinkById(Long id);
    void updateLink(Link updatedLink);
    Link findLinkById(Long id);
    List<Link> findAllLink();
    List<Link> findAllLinkByQuestionId(Long id);
}
