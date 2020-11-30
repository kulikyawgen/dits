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

import java.util.Arrays;
import java.util.List;

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
        Mockito.doNothing()
                .when(literatureRepository)
                .deleteLiteratureById(1);
        Assert.assertTrue(literatureService.deleteLiteratureById(1));
    }

    @Test
    public void deleteLiterature_should_return_false(){
        Mockito.doReturn(null)
                .when(literatureRepository)
                .findLiteratureById(1);
        Assert.assertFalse(literatureService.deleteLiteratureById(1));
    }


    @Test
    public void getLiterature_should_return_literature(){
        Literature literature = new Literature();
        literature.setLiteratureId(1);
        Mockito.doReturn(literature)
                .when(literatureRepository)
                .findLiteratureById(1);
        Assert.assertEquals(literature,literatureService.getLiteratureById(1));
    }

    @Test
    public void getAllLiterature_should_return_list_literature(){
        Literature literature = new Literature();
        List<Literature> literatureList = Arrays.asList(literature);
        Mockito.doReturn(literatureList)
                .when(literatureRepository)
                .findAll();
        Assert.assertEquals(literatureList,literatureService.getAllLiterature());
    }

    @Test
    public void getAllLiteratureByQuestionId_should_return_list_literature(){
        Literature literature = new Literature();
        List<Literature> literatureList = Arrays.asList(literature);
        Mockito.doReturn(literatureList)
                .when(literatureRepository)
                .findAllLiteratureByQuestionId(1);
        Assert.assertEquals(literatureList,literatureService.getAllLiteratureByQuestionId(1));
    }
}
