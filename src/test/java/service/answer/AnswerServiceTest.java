package service.answer;

import com.model.Answer;
import com.model.Link;
import com.repository.answer.AnswerRepository;
import com.service.answer.AnswerService;
import com.service.answer.AnswerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void getAnswer_should_return_answer(){
        Answer answer = new Answer();
        answer.setAnswerId(1);
        Mockito.doReturn(answer)
                .when(answerRepository)
                .findAnswerById(1);
        Assert.assertEquals(answer,answerService.getAnswerById(1));
    }

    @Test
    public void getAllAnswers_should_return_list_answers(){
        Answer answer = new Answer();
        answer.setAnswerId(1);
        List<Answer> list = Arrays.asList(answer);
        Mockito.doReturn(list)
                .when(answerRepository)
                .findAll();
        Assert.assertEquals(list,answerService.getAllAnswers());
    }
    @Test
    public void getAllAnswersByQuestionId_should_return_list_answers(){
        Answer answer = new Answer();
        answer.setAnswerId(1);
        List<Answer> list = Arrays.asList(answer);
        Mockito.doReturn(list)
                .when(answerRepository)
                .findAllAnswersByQuestionId(1);
        Assert.assertEquals(list,answerService.getAllAnswersByQuestionId(1));
    }

    @Test
    public void getTrueAnswersForQuestion_should_return_list_answers(){
        Answer answer = new Answer();
        answer.setAnswerId(1);
        List<Answer> list = Arrays.asList(answer);
        Mockito.doReturn(list)
                .when(answerRepository)
                .findTrueAnswersForQuestion(1);
        Assert.assertEquals(list,answerService.getTrueAnswersForQuestion(1));
    }



}
