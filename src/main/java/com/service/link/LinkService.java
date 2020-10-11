/*
@author Andrei Gorevoi
*/
package com.service.link;

import com.model.Link;

import java.util.List;

public interface LinkService {
    void addLink(Link newLink);
    void deleteLinkById(Long id);
    void updateLink(Link updatedLink);
    Link getLinkById(Long id);
    List<Link> getAllLink();
//    List<Link> getAllLinkByQuestionId(Long id);
}
