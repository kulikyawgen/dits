/*
@author Andrei Gorevoi
*/
package com.service.literature;

import com.model.Literature;

import java.util.List;

public interface LiteratureService {
    void addLiterature(Literature newLiterature);
    void deleteLiteratureById(Long id);
    void updateLiterature(Literature updatedLiterature);
    Literature getLiteratureById(Long id);
    List<Literature> getAllLiterature();
    List<Literature> getAllLiteratureByQuestionId(Long id);
}
