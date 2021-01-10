package com.service.statistic;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface StatisticAfterService {
    public void getStatisticAfterTest(HttpSession session, Model model);
}
