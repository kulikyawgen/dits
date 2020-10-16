package com.service.topic;

import com.mapper.TopicMapper;
import com.model.Topic;
import com.repository.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private TopicMapper topicMapper;

    @Override
    public Topic create(Topic topic) {
        topic.setTopicId(0);
        return topicRepository.save(topic);
    }

    @Override
    public Topic update(Topic topic) {
        Topic fromDB = getOne(topic.getTopicId());
        topicMapper.update(topic, fromDB);
        return topicRepository.save(fromDB);
    }

    @Override
    public Topic getOne(int id) {
        return topicRepository.findById(id).orElse(null);
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
}