package com.service.statistic;

import com.model.PersonalStatisticForUser;

import java.util.List;

public interface PersonalStatisticService {
    public List<PersonalStatisticForUser> getPersonalStatistic(int userId);
}
