package service.answer;

import com.model.Answer;
import com.repository.answer.AnswerRepository;
import com.service.answer.AnswerService;
import com.service.answer.AnswerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AnswerServiceTest {

    @Mock
    private AnswerRepository answerRepository;
    private AnswerService answerService;

    public AnswerServiceTest() {
        MockitoAnnotations.openMocks(this);
        answerService = new AnswerServiceImpl(answerRepository);
    }

    @Test
    public void addAnswerTest_should_return_answer(){
        Answer answer = new Answer();
        Mockito.doReturn(answer)
                .when(answerRepository)
                .save(answer);
        Answer savedAnswer = answerService.addAnswer(answer);
        Assert.assertEquals(answer, savedAnswer);

    }

    @Test
    public void deleteAnswer_should_return_false(){
        Mockito.doReturn(null)
                .when(answerRepository)
                .findAnswerById(1);
        Mockito.doNothing()
                .when(answerRepository)
                .deleteAnswerById(1);
        boolean b = answerService.deleteAnswerById(1);
        Assert.assertFalse(b);
    }

    @Test
    public void deleteAnswer_should_return_true(){
        Mockito.doReturn(new Answer())
                .when(answerRepository)
                .findAnswerById(1);
        Mockito.doNothing()
                .when(answerRepository)
                .deleteAnswerById(1);
        boolean b = answerService.deleteAnswerById(1);
        Assert.assertTrue(b);
    }

}
