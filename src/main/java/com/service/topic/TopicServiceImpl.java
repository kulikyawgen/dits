package com.service.topic;

import com.model.Topic;
import com.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Beans;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public Topic create(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic update(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic getOne(int id) {
        return topicRepository.getOne(id);
    }

    @Override
    public Page<Topic> getPage(int page, int size, String order, String... params) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(order), params);
        return topicRepository.findAll(pageable);
    }

    @Override
    public void deleteById(int id) {
        topicRepository.deleteById(id);
    }

    @Override
    public void delete(Topic topic) {
        topicRepository.delete(topic);
    }
}