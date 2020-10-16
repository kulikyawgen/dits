package com.mapper;

import com.dto.AnswerDto;
import com.model.Answer;
import com.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AnswerMapper {

    @Mapping(source = "questionId", target = "questionid")
    Answer toAnswer(AnswerDto dto);

    @Mapping(source = "questionid", target = "questionId")
    AnswerDto toAnswerDto(Answer entity);

    void update(AnswerDto from, @MappingTarget Answer answer);

    void update(Answer from, @MappingTarget Answer answer);

    default int toDto(Question question) {
        return question.getQuestionId();
    }

    default Question toEntity(int questionId) {
        if (questionId == 0) {
            return null;
        }
        Question question = new Question();
        question.setQuestionId(questionId);
        return question;
    }
}