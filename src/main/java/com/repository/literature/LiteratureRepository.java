/*
@author Andrei Gorevoi
*/
package com.repository.literature;

import com.model.Literature;

import java.util.List;

public interface LiteratureRepository  {
    void addLiterature(Literature newLiterature);
    void deleteLiteratureById(Long id);
    void updateLiterature(Literature updatedLiterature);
    Literature findLiteratureById(Long id);
    List<Literature> findAllLiterature();
    List<Literature> findAllLiteratureByQuestionId(Long id);
}
