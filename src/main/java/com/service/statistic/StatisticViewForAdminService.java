package com.service.statistic;

import com.model.StatisticViewForAdmin;
import com.model.Question;
import com.model.Test;

import java.util.List;

public interface StatisticViewForAdminService {
    List<StatisticViewForAdmin> getTestStatisticList();

    StatisticViewForAdmin getTestInfo(Test test);

    StatisticViewForAdmin getQuestionInfo(Question question);

    List<StatisticViewForAdmin> getQuestionStatisticList();

    List<StatisticViewForAdmin> getUserTestStatisticList();
}
