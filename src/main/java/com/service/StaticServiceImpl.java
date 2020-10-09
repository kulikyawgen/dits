package com.service;

import com.model.Static;
import com.repository.StaticRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class StaticServiceImpl implements StaticService {
    @Autowired
    private StaticRepo staticRepo;

    @Override
    public List<Static> getAllByDate(Date date) {
        List<Static> allByDate = staticRepo.getAllByDate(date);
        return allByDate;
    }
}
