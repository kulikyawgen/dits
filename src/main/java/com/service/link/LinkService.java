/*
@author Andrei Gorevoi
*/
package com.service.link;

import com.model.Link;

import java.util.List;

public interface LinkService {
    Link addLink(Link newLink);
    boolean deleteLinkById(int id);
    void updateLink(Link updatedLink);
    Link getLinkById(int id);
    List<Link> getAllLink();
    List<Link> getAllLinkByLiteratureId(int id);
}
