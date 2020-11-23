package com.repository.test;

import com.model.Test;
import com.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    Page<Test> findByTopic(Pageable pageable, Topic topic);

    Page<Test> findAll(Pageable pageable);

    List<Test> findAll();

    Test findByName(String name);
}