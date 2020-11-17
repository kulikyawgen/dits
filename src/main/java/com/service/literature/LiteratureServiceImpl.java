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

    /**
     *
     * @param newLiterature
     * @return Literature
     * Метод принимает объет литературы и сохраняет ее в базе данных
     */
    @Override
    public Literature addLiterature(Literature newLiterature) {
        return literatureRepository.save(newLiterature);
    }

    /**
     *
     * @param id
     * Метод удаляет литературу из базы данных по id из параметра
     */
    @Override
    public void deleteLiteratureById(int id) {
        literatureRepository.deleteLiteratureById(id);
    }

    /**
     *
     * @param updatedLiterature
     * Метод принимает объект литературы сохраняет ее базе данных
     */
    @Override
    public void updateLiterature(Literature updatedLiterature) {
        literatureRepository.save(updatedLiterature);
    }

    /**
     *
     * @param id
     * @return Literature
     * Метод возвращает литературу по id из параметра
     */
    @Override
    public Literature getLiteratureById(int id) {
        return literatureRepository.findLiteratureById(id);
    }

    /**
     *
     * @return List<Literature>
     * Метод возвращает всю имеющиеся в базе данных литературу
     */
    @Override
    public List<Literature> getAllLiterature() {
        return literatureRepository.findAll();
    }

    /**
     *
     * @param id
     * @return List<Literature>
     * Метод возвращает всю имеющуюся литературу в базе данных для конкретного вопроса по id из параметра
     */
    @Override
    public List<Literature> getAllLiteratureByQuestionId(int id) {
        return literatureRepository.findAllLiteratureByQuestionId(id);
    }
}
