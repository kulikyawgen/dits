/*
@author Andrei Gorevoi
*/
package com.controller.staticstic;

import com.dto.AnswerDto;
import com.dto.QuestionDto;
import com.model.Answer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("statistic")
public class StatisticRestController {
    @PostMapping("/")
    public String saveAnswerToStatistic(@RequestParam List<String> answers, @RequestParam int questionId,HttpSession session){
        Map<Integer,List<String>> answersMap = (Map<Integer, List<String>>) session.getAttribute("answersMap");
        answersMap.put(questionId,answers);
        return null;
    }
}
