package com.service.topic;

import com.dto.TopicDto;
import com.mapper.TopicMapper;
import com.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopicDtoServiceWrapper {

    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicMapper topicMapper;

    public Page<TopicDto> getPage(int page, int size, String order, String... params) {
        return topicService.getPage(page, size, order, params).map(topicMapper::toTopicDto);
    }

    public TopicDto create(TopicDto topic) {
        return topicMapper.toTopicDto(topicService.create(topicMapper.toTopic(topic)));
    }

    public TopicDto update(TopicDto topicDto) {
        Topic topic = topicService.getOne(topicDto.getTopicId());
        topic = topicMapper.toTopic(topicDto);
        return topicMapper.toTopicDto(topic);
    }
}