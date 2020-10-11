package com.service.topic;

import com.dto.TopicDto;
import com.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TopicDtoServiceDecorator {

    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicMapper topicMapper;

    public Page<TopicDto> getPage(int page, int size, String order, String... params) {
        return topicService.getPage(page, size, order, params).map(topicMapper::toTopicDto);
    }
}