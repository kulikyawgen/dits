package com.repository.statistic;

import com.model.Static;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface StaticRepo extends JpaRepository<Static, Long> {
    @Query("select s from Static s where s.date = :date")
    List<Static> getAllByDate(Date date);
}
