package com.service.statistic;

import com.model.Static;
import com.repository.statistic.StaticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StaticServiceImpl implements StaticService {
    @Autowired
    private StaticRepo staticRepo;

    @Override
    public List<Static> getAllByDate(Date date) {
        return staticRepo.getAllByDate(date);
    }
}