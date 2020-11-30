/*
@author Andrei Gorevoi
*/
package com.service.literature;

import com.model.Literature;

import java.util.List;

public interface LiteratureService {
    Literature addLiterature(Literature newLiterature);
    boolean deleteLiteratureById(int id);
    void updateLiterature(Literature updatedLiterature);
    Literature getLiteratureById(int id);
    List<Literature> getAllLiterature();
    List<Literature> getAllLiteratureByQuestionId(int id);
}
