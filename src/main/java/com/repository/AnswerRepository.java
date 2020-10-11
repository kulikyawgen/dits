/*
@author Andrei Gorevoi
*/
package com.repository;

import com.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}