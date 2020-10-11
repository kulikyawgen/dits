package com.mapper;

import com.dto.TestDto;
import com.model.Test;
import com.model.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestMapper {
    @Mapping(source = "topicId", target = "topic")
    Test toTest(TestDto dto);

    @Mapping(source = "topic", target = "topicId")
    TestDto toTestDto(Test entity);

    default int toDto(Topic topic) {
        return topic.getTopicId();
    }

    default Topic toEntity(int topicId) {
        Topic topic = new Topic();
        topic.setTopicId(topicId);
        return topic;
    }
}