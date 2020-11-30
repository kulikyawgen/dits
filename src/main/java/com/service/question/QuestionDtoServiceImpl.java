/*
@author Andrei Gorevoi
*/
package com.service.question;

import com.dto.QuestionDto;
import com.model.Question;
import com.model.Statistic;
import com.model.Test;
import com.mysql.cj.Session;
import com.service.answer.AnswerService;
import com.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class QuestionDtoServiceImpl implements QuestionDtoService {
    private final TestService testService;
    private final AnswerService answerService;

    @Autowired
    public QuestionDtoServiceImpl(TestService testService, AnswerService answerService) {
        this.testService = testService;
        this.answerService = answerService;
    }

    public void questionsToSession(int id,HttpSession session){
        Test test = testService.getOne(id);
        Map<Integer, List<String>> answersMap = new HashMap<>();
        List<Question> questions = test.getQuestions();
        List<QuestionDto> questionDtoList = new ArrayList<>();
//        Convert questions to dtoQuestion and adding to dtoList;
        for (Question question : questions) {
            QuestionDto questionDto = new QuestionDto();
            questionDto = questionDto.convertToDto(question,answerService.getAllAnswersByQuestionId(question.getQuestionId()));
            questionDtoList.add(questionDto);
        }
        session.setAttribute("questions",questionDtoList);
        session.setAttribute("passingTest",test);
        session.setAttribute("answersMap",answersMap);
        session.setAttribute("userId", 21);
        session.setAttribute("startTime",new Date(System.currentTimeMillis()));
        session.setAttribute("statistics", new ArrayList<Statistic>());
    }

    @Override
    public List<QuestionDto> getQuestionsFromSession(HttpSession session) {
        return (List<QuestionDto>) session.getAttribute("questions");
    }

    @Override
    public QuestionDto findNoAnsweredQuestion(List<QuestionDto> questionDtoList) {
        for (QuestionDto questionDto : questionDtoList) {
            if (questionDto.isAnswered()){
                continue;
            }
            Collections.shuffle(questionDto.getAnswers());
            return questionDto;
        }
        return null;
    }
}
