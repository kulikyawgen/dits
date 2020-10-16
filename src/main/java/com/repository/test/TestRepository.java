package com.repository.test;

import com.model.Test;
import com.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    Page<Test> findByTopic(Pageable pageable, Topic topic);

    Page<Test> findAll(Pageable pageable);
}