package com.service.viewStatistic;

import com.model.Question;
import com.model.Statistic;
import com.model.Test;
import com.model.ViewStatistic;

import java.util.List;

public interface ViewStatisticService {
    List<ViewStatistic> getTestStatisticList();

    ViewStatistic getTestInfo(Test test);

    ViewStatistic getQuestionInfo(Question question);

    List<ViewStatistic> getQuestionStatisticList();

    ViewStatistic getUserTestInfo(Statistic statistic);

    List<ViewStatistic> getUserTestStatisticList();


}
