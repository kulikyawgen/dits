package com.mapper;

import com.dto.TestDto;
import com.model.Test;
import com.model.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = QuestionMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TestMapper {
    @Mapping(source = "topicId", target = "topic")
    Test toTest(TestDto dto);

    @Mapping(source = "topic", target = "topicId")
    TestDto toTestDto(Test entity);

    void update(TestDto from, @MappingTarget Test test);

    void update(Test from, @MappingTarget Test test);

    default int toDto(Topic topic) {
        return topic.getTopicId();
    }

    default Topic toEntity(int topicId) {
        Topic topic = new Topic();
        topic.setTopicId(topicId);
        return topic;
    }
}