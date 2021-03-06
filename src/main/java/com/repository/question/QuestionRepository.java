package com.repository.question;

import com.model.Question;
import com.model.Test;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Page<Question> findAll(Pageable pageable);

    Page<Question> findByTest(Pageable pageable, Test test);

    List<Question> findAll();

}