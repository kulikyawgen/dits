/*
@author Andrei Gorevoi
*/
package com.repository.topic;

import com.model.Topic;

import java.util.List;

public interface TopicRepository {
    void addTopic(Topic newTopic);
    void deleteTopicById(Long id);
    void deleteTopicByName(String name);
    void updateTopic(Topic updatedTopic);
    Topic findTopicById(Long id);
    Topic findTopicByName(String name);
    List<Topic> findAllTopics();
}
