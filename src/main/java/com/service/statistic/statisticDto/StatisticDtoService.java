package com.service.statistic.statisticDto;

import com.dto.StatisticDto;
import com.model.Question;
import com.model.Test;

import java.util.List;

public interface StatisticDtoService {
    List<StatisticDto> getTestStatisticList();

    StatisticDto getTestInfo(Test test);

    StatisticDto getQuestionInfo(Question question);

    List<StatisticDto> getQuestionStatisticList();

    List<StatisticDto> getUserTestStatisticList();
}
