package ua.lazin.vladyslav.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lazin.vladyslav.dao.CrudDAO;
import ua.lazin.vladyslav.entity.Ad;
import ua.lazin.vladyslav.service.CrudService;

import java.util.List;

@Service
@AllArgsConstructor
public class AdServiceImpl implements CrudService<Ad> {
    CrudDAO<Ad> adDAO;

    @Override
    public void save(Ad ad) {
        adDAO.save(ad);
    }

    @Override
    public void update(Ad ad) {
        adDAO.update(ad);
    }

    @Override
    public void deleteById(int id) {
        adDAO.deleteById(id);
    }

    @Override
    public Ad findById(int id) {
        return adDAO.findById(id);
    }

    @Override
    public List<Ad> findAll() {
        return adDAO.findAll();
    }
}
