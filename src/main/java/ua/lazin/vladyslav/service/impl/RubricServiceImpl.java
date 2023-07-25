package ua.lazin.vladyslav.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lazin.vladyslav.dao.CrudDAO;
import ua.lazin.vladyslav.entity.Rubric;
import ua.lazin.vladyslav.service.CrudService;

import java.util.List;
@Service
@AllArgsConstructor
public class RubricServiceImpl implements CrudService<Rubric> {
    CrudDAO<Rubric> rubricDAO;

    @Override
    public void save(Rubric rubric) {
        rubricDAO.save(rubric);
    }

    @Override
    public void update(Rubric rubric) {
        rubricDAO.update(rubric);
    }

    @Override
    public void deleteById(int id) {
    rubricDAO.deleteById(id);
    }

    @Override
    public Rubric findById(int id) {
        return rubricDAO.findById(id);
    }

    @Override
    public List<Rubric> findAll() {
        return rubricDAO.findAll();
    }
}
