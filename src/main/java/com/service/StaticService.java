package com.service;

import com.domain.Static;

import java.util.Date;
import java.util.List;

public interface StaticService {
    List<Static> getAllByDate(Date date);
}
