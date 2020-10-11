package com.mapper;

import com.dto.TopicDto;
import com.model.Topic;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TopicMapper {
    Topic toTopic(TopicDto dto);

    TopicDto toTopicDto(Topic entity);
}