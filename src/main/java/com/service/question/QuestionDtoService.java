/*
@author Andrei Gorevoi
*/
package com.service.question;

import com.dto.QuestionDto;
import com.mysql.cj.Session;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface QuestionDtoService {
    /**
     *
     * @param id
     * @param session
     * Данный метод вытягивает из базы данных тест, его вопросы и помещяет их в сессию.
     * P.S. Используется при первом попадании в метод passingTest.
     */
    void questionsToSession(int id, HttpSession session);

    List<QuestionDto> getQuestionsFromSession(HttpSession session);
    QuestionDto findNoAnsweredQuestion(List<QuestionDto> questionDtoList);

}
