package com.service.topic;

import com.model.Topic;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TopicService {

    Topic create(Topic topic);

    Topic update(Topic topic);

    Topic getOne(int id);

    Page<Topic> getPage(int page, int size, String order, String... params);

    void deleteById(int id);

    List<Topic> getAll();

    Topic getByName(String name);
}