package com.service.statistic;

import com.model.Static;

import java.util.Date;
import java.util.List;

public interface StaticService {
    List<Static> getAllByDate(Date date);
}
