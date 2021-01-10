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

    /**
     *
     * @param newLink
     * @return Link
     * Метод принимает объект сслыки и сохраняет его в базу данных
     */
    @Override
    public Link addLink(Link newLink) {
        return linkRepository.save(newLink);
    }

    /**
     *
     * @param id
     * Метод удаляет ссылку из базы данных по ее id
     */
    @Override
    public boolean deleteLinkById(int id) {
        if(linkRepository.findLinkById(id)==null){
            return false;
        }else {
            linkRepository.deleteLinkById(id);
            return true;
        }
    }

    /**
     *
     * @param updatedLink
     * Метод принимает объект ссылки и обновляет ее в базе данных
     */
    @Override
    public void updateLink(Link updatedLink) {
        linkRepository.save(updatedLink);
    }

    /**
     *
     * @param id
     * @return Link
     * Метод ищет в возвращает ссылку id из параметра
     */
    @Override
    public Link getLinkById(int id) {
        return linkRepository.findLinkById(id);
    }

    /**
     *
     * @return List<Link>
     *     Метод возвращает все имеющиеся ссылки в базе данных
     */
    @Override
    public List<Link> getAllLink() {
        return linkRepository.findAll();
    }

    /**
     *
     * @param id
     * @return List<Link>
     *     Метод возвращает все ссылки из базы данных для литературы по ее id
     */
    @Override
    public List<Link> getAllLinkByLiteratureId(int id) {
        return linkRepository.findAllLinkByLiteratureId(id);
    }
}
