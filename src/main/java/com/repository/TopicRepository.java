package com.repository;

import com.model.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository {

    void create(Topic topic);

    void update(Topic topic);

    Topic get(int id);

    List<Topic> getAll();

    void deleteById(int id);

    void delete(Topic topic);
}