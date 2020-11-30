package service.link;

import com.model.Link;
import com.model.Literature;
import com.repository.link.LinkRepository;
import com.service.link.LinkService;
import com.service.link.LinkServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class LinkServiceTest {

    @Mock
    private LinkRepository linkRepository;

    private LinkService linkService;

    public LinkServiceTest() {
        MockitoAnnotations.openMocks(this);
        linkService = new LinkServiceImpl(linkRepository);
    }

    @Test
    public void addLink_should_return_Link(){
        Link link = new Link();
        Mockito.doReturn(link)
                .when(linkRepository)
                .save(link);

        Assert.assertEquals(link,linkService.addLink(link));
    }

    @Test
    public void deleteLink_should_return_true(){
        Mockito.doReturn(new Link())
                .when(linkRepository)
                .findLinkById(1);
        Assert.assertTrue(linkService.deleteLinkById(1));
    }

    @Test
    public void deleteLink_should_return_false(){
        Mockito.doReturn(null)
                .when(linkRepository)
                .findLinkById(1);
        Assert.assertFalse(linkService.deleteLinkById(1));
    }

    @Test
    public void getLink_should_return_link(){
        Link link = new Link();
        link.setLinkId(1);
        Mockito.doReturn(link)
                .when(linkRepository)
                .findLinkById(1);
        Assert.assertEquals(link,linkService.getLinkById(1));
    }

    @Test
    public void getAllLinks_should_return_list_links(){
        Link link = new Link();
        link.setLinkId(1);
        List<Link> links = Arrays.asList(link);
        Mockito.doReturn(links)
                .when(linkRepository)
                .findAll();
        Assert.assertEquals(links,linkService.getAllLink());
    }


    @Test
    public void getAllLinkByLiteratureId_should_return_list_links(){
        Link link = new Link();
        link.setLinkId(1);
        List<Link> links = Arrays.asList(link);
        Mockito.doReturn(links)
                .when(linkRepository)
                .findAllLinkByLiteratureId(1);
        Assert.assertEquals(links,linkService.getAllLinkByLiteratureId(1));
    }
}
