/*
@author Andrei Gorevoi
*/
package repository.answer;

import com.model.Answer;
import com.model.Question;
import com.repository.answer.AnswerRepository;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class AnswerRepositoryTest {

    @Mock
    private AnswerRepository answerRepository;

    public AnswerRepositoryTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test(){
        given(answerRepository.findAnswerById(1)).willReturn(new Answer(1,"some descr",true,new Question()));
        Answer answer = answerRepository.findAnswerById(1);
        assertThat(answer.getDescription()).isEqualTo("some descr22");

    }
}
