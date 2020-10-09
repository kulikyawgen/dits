package com.service;

import com.model.Static;

import java.util.Date;
import java.util.List;

public interface StaticService {
    List<Static> getAllByDate(Date date);
}
