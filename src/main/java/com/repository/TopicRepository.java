package com.dao;

import com.model.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository {

    Topic create(Topic topic);

    Topic update(Topic topic);

    Topic get(int id);

    List<Topic> getAll();

    Topic delete(int id);

    Topic delete(Topic topic);
}