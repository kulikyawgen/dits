package com.mapper;

import com.dto.TopicDto;
import com.model.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = TestMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TopicMapper {
    Topic toTopic(TopicDto dto);

    TopicDto toTopicDto(Topic entity);

    void update(TopicDto from, @MappingTarget Topic to);

    void update(Topic from, @MappingTarget Topic to);
}