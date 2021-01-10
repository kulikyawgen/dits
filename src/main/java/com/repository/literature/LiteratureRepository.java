/*
@author Andrei Gorevoi
*/
package com.repository.literature;

import com.model.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiteratureRepository extends JpaRepository<Literature,Integer> {
    @Query("delete from Literature where literatureId=?1")
    void deleteLiteratureById(int id);

    @Query("from Literature where literatureId=?1")
    Literature findLiteratureById(int id);

    @Query("from Literature l where l.questionid.questionId=?1 ")
    List<Literature> findAllLiteratureByQuestionId(int id);
}
