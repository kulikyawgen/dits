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
    public void addLiterature(Literature newLiterature) {
        literatureRepository.addLiterature(newLiterature);

    }

    @Override
    public void deleteLiteratureById(Long id) {
        literatureRepository.deleteLiteratureById(id);
    }

    @Override
    public void updateLiterature(Literature updatedLiterature) {
        literatureRepository.updateLiterature(updatedLiterature);
    }

    @Override
    public Literature getLiteratureById(Long id) {
        return literatureRepository.findLiteratureById(id);
    }

    @Override
    public List<Literature> getAllLiterature() {
        return literatureRepository.findAllLiterature();
    }

    @Override
    public List<Literature> getAllLiteratureByQuestionId(Long id) {
        return literatureRepository.findAllLiteratureByQuestionId(id);
    }
}
