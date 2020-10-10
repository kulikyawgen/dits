package com.service.question;

import com.model.Question;
import org.springframework.data.domain.Page;

public interface QuestionService {

    Question create(Question question);

    Question update(Question question);

    Question getOne(int id);

    Page<Question> getPage(int page, int size, String order, String... params);

    Page<Question> getByTopic(int testId, int page, int size, String order, String... params);

    void deleteById(int id);

    void delete(Question question);
}