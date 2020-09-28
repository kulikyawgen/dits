/*
@author Andrei Gorevoi
*/
package com.service.topic;

import com.model.Topic;

import java.util.List;

public interface TopicService {
    void addTopic(Topic newTopic);
    void deleteTopicById(Long id);
    void deleteTopicByName(String name);
    void updateTopic(Topic updatedTopic);
    Topic getTopicById(Long id);
    Topic getTopicByName(String name);
    List<Topic> getAllTopics();
}
