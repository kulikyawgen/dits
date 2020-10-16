/*
@author Andrei Gorevoi
*/
package com.controller.link;

import com.model.Link;
import com.service.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("link")
public class LinkRestController {

    private final LinkService linkService;

    @Autowired
    public LinkRestController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping(value = "/")
    public Link addLink(@RequestBody Link link){
        return linkService.addLink(link);
    }

    @GetMapping(value = "/delete/{id}")
    public void deteleLink(@PathVariable int id){
        linkService.deleteLinkById(id);
    }

    @GetMapping(value = "/")
    public List<Link> getAllLinks(){
        return linkService.getAllLink();
    }

    @GetMapping(value = "/{id}")
    public Link getLinkById(@PathVariable int id){
        return linkService.getLinkById(id);
    }

    @GetMapping(value = "/byanswer/{id}")
    public List<Link> getLinkByAnswer(@PathVariable int id){
        return linkService.getAllLinkByLiteratureId(id);
    }
}
