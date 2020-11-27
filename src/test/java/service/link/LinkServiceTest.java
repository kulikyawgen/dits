package service.link;

import com.model.Link;
import com.repository.link.LinkRepository;
import com.service.link.LinkService;
import com.service.link.LinkServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
}
