package service.literature;

import com.model.Literature;
import com.repository.literature.LiteratureRepository;
import com.service.literature.LiteratureService;
import com.service.literature.LiteratureServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LiteratureServiceTest {

    @Mock
    private LiteratureRepository literatureRepository;
    private LiteratureService literatureService;

    public LiteratureServiceTest() {
        MockitoAnnotations.openMocks(this);
        literatureService= new LiteratureServiceImpl(literatureRepository);
    }

    @Test
    public void addLiterature_should_return_literature(){
        Literature literature = new Literature();
        Mockito.doReturn(literature)
                .when(literatureRepository)
                .save(literature);
        Assert.assertEquals(literature, literatureService.addLiterature(literature));
    }

    @Test
    public void deleteLiterature_should_return_true(){
        Mockito.doReturn(new Literature())
                .when(literatureRepository)
                .findLiteratureById(1);
        Assert.assertTrue(literatureService.deleteLiteratureById(1));
    }

    @Test
    public void deleteLiterature_should_return_false(){
        Mockito.doReturn(null)
                .when(literatureRepository)
                .findLiteratureById(1);
        Assert.assertFalse(literatureService.deleteLiteratureById(1));
    }
}
