/*
@author Andrei Gorevoi
*/
package com.service.topic;

import com.model.Topic;
import com.repository.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public void addTopic(Topic newTopic) {
    topicRepository.addTopic(newTopic);
    }

    @Override
    public void deleteTopicById(Long id) {
        topicRepository.deleteTopicById(id);
    }

    @Override
    public void deleteTopicByName(String name) {
        topicRepository.deleteTopicByName(name);
    }

    @Override
    public void updateTopic(Topic updatedTopic) {
        topicRepository.updateTopic(updatedTopic);
    }

    @Override
    public Topic getTopicById(Long id) {
        return topicRepository.findTopicById(id);
    }

    @Override
    public Topic getTopicByName(String name) {
        return topicRepository.findTopicByName(name);
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAllTopics();
    }
}
