package com.mapper;

import com.dto.QuestionDto;
import com.model.Question;
import com.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = AnswerMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface QuestionMapper {
    @Mapping(source = "testId", target = "test")
    Question toQuestion(QuestionDto dto);

    @Mapping(source = "test", target = "testId")
    QuestionDto toQuestionDto(Question entity);

    void update(QuestionDto from, @MappingTarget Question to);

    void update(Question from, @MappingTarget Question to);

    default int toDto(Test entity) {
        return entity.getTestId();
    }

    default Test toEntity(int testId) {
        if (testId == 0) {
            return null;
        }
        Test test = new Test();
        test.setTestId(testId);
        return test;
    }
}