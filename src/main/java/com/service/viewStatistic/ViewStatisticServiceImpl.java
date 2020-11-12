package com.service.viewStatistic;

import com.model.Question;
import com.model.Statistic;
import com.model.Test;
import com.model.ViewStatistic;
import com.service.question.QuestionServiceImpl;
import com.service.statistic.StatisticServiceImpl;
import com.service.test.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ViewStatisticServiceImpl implements ViewStatisticService {
    @Autowired
    private TestServiceImpl testServiceimpl;

    @Autowired
    private StatisticServiceImpl statisticService;

    @Autowired
    private QuestionServiceImpl questionService;

    @Override
    public List<ViewStatistic> getQuestionStatisticList() {
        List<ViewStatistic> questionList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Question> allQuestion = questionService.getAllQuestion();
        for (Question question : allQuestion) {
            viewStatistic = getQuestionInfo(question);
            if (viewStatistic != null) {
                questionList.add(viewStatistic);
            }
        }
        return questionList;
    }

    @Override
    public ViewStatistic getQuestionInfo(Question question) {
        ViewStatistic viewStatistic;
        viewStatistic = null;
        List<Statistic> allStatisticByQuestionId = statisticService.getAllStatisticByQuestionId(question.getQuestionId());
        if (!allStatisticByQuestionId.isEmpty()) {
            int size = allStatisticByQuestionId.size();
            int countOfCorrectAnswers = 0;
            for (Statistic statistic : allStatisticByQuestionId) {
                if (statistic.isCorrect()) {
                    countOfCorrectAnswers++;
                }
                viewStatistic = new ViewStatistic();
                viewStatistic.setName(question.getDescription());
                viewStatistic.setCountCompleted(size);
                viewStatistic.setPercent((int) Math.round(((double) countOfCorrectAnswers) / size * 100));
            }
        } else viewStatistic = null;
        return viewStatistic;
    }

    @Override
    public List<ViewStatistic> getTestStatisticList() {
        List<ViewStatistic> testInfoList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Test> allTests = testServiceimpl.getAllTests();
        for (Test test : allTests) {
            viewStatistic = getTestInfo(test);
            if (viewStatistic != null) {
                testInfoList.add(viewStatistic);
            }
        }
        testInfoList.sort(Comparator.comparing(ViewStatistic::getName));
        return testInfoList;
    }

    @Override
    public ViewStatistic getTestInfo(Test test) {
        ViewStatistic viewStatistic;
        List<Statistic> allStatistic = statisticService.getFilteredStatisticByTestId(test.getTestId());
        if (!allStatistic.isEmpty()) {
            int numberOfQuestionInTest = test.getQuestions().size();
            int size = allStatistic.size();
            viewStatistic = new ViewStatistic();
            viewStatistic.setName(test.getName());
            viewStatistic.setCountCompleted(size / numberOfQuestionInTest);
            viewStatistic.setPercent((int) Math.round(((double) numberOfQuestionInTest) / size * 100));// viewStatistic.setPercent();
        } else viewStatistic = null;
        return viewStatistic;
    }

    @Override
    public List<ViewStatistic> getUserTestStatisticList() {
        ViewStatistic viewStatistic;
        List<ViewStatistic> userTestInfoList = new ArrayList<>();
        List<Statistic> allStatistic = statisticService.findAll();
        for (Statistic statistic : allStatistic) {
            viewStatistic = getUserTestInfo(statistic);
            if (viewStatistic != null){
                userTestInfoList.add(viewStatistic);
            }
        }
        userTestInfoList.sort(Comparator.comparing(ViewStatistic::getLogin));
        return userTestInfoList;
    }

    @Override
    public ViewStatistic getUserTestInfo(Statistic statistic) {
        ViewStatistic viewStatistic;
         List<Statistic> filteredStatisticByTestUser = statisticService.
                 getFilteredStatisticByTestUser(statistic.getUser().getUserId());
         if (!filteredStatisticByTestUser.isEmpty()){
//             statistic
//             viewStatistic = new ViewStatistic();
//             viewStatistic.setName(statistic.getUser().getLogin());
//             viewStatistic.setCountCompleted();
         }
        return null;
    }

    public List<Statistic> getst() {
        final List<Statistic> filteredStatisticByTestId = statisticService.getFilteredStatisticByTestId(1);
        return filteredStatisticByTestId;
    }
}
