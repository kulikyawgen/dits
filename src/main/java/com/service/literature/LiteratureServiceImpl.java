/*
@author Andrei Gorevoi
*/
package com.service.literature;

import com.model.Literature;
import com.repository.LiteratureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        literatureRepository.save(newLiterature);

    }

    @Override
    public void deleteLiteratureById(Long id) {
        literatureRepository.deleteById(id);
    }

    @Override
    public void updateLiterature(Literature updatedLiterature) {
        literatureRepository.save(updatedLiterature);
    }

    @Override
    public Literature getLiteratureById(Long id) {
        return literatureRepository.getOne(id);
    }

    @Override
    public List<Literature> getAllLiterature() {
        return literatureRepository.findAll();
    }

//    @Override
//    public List<Literature> getAllLiteratureByQuestionId(Long id) {
//        return literatureRepository.findAllLiteratureByQuestionId(id);
//    }
}
