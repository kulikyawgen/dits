package com.mapper;

import com.dto.QuestionDto;
import com.model.Question;
import com.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface QuestionMapper {

    Question toQuestion(QuestionDto dto);

    QuestionDto toQuestionDto(Question entity);

    void update(QuestionDto from, @MappingTarget Question to);

    void update(Question from, @MappingTarget Question to);

    default int toDto(Test entity) {
        return entity.getTestId();
    }

    default Test toEntity(int testId) {
        Test test = new Test();
        test.setTestId(testId);
        return test;
    }
}