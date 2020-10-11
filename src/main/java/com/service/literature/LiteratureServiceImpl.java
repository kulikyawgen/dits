/*
@author Andrei Gorevoi
*/
package com.service.literature;

import com.model.Literature;
import com.repository.literature.LiteratureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LiteratureServiceImpl implements LiteratureService {

    private final LiteratureRepository literatureRepository;
    @Autowired
    public LiteratureServiceImpl(LiteratureRepository literatureRepository) {
        this.literatureRepository = literatureRepository;
    }


    @Override
    public Literature addLiterature(Literature newLiterature) {
        return literatureRepository.save(newLiterature);
    }

    @Override
    public void deleteLiteratureById(int id) {
        literatureRepository.deleteLiteratureById(id);
    }

    @Override
    public void updateLiterature(Literature updatedLiterature) {
        literatureRepository.save(updatedLiterature);
    }

    @Override
    public Literature getLiteratureById(int id) {
        return literatureRepository.findLiteratureById(id);
    }

    @Override
    public List<Literature> getAllLiterature() {
        return literatureRepository.findAll();
    }

    @Override
    public List<Literature> getAllLiteratureByQuestionId(int id) {
        return literatureRepository.findAllLiteratureByQuestionId(id);
    }
}
