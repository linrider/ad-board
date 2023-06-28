package ua.lazin.vladyslav.service.impl;

import java.util.List;

import ua.lazin.vladyslav.dao.CrudDAO;
import ua.lazin.vladyslav.dao.impl.CrudDAOImpl;
import ua.lazin.vladyslav.service.CrudService;

public class CrudServiceImpl<T> implements CrudService<T> {
    CrudDAO<T> crudDAO;

    public CrudServiceImpl() {
        crudDAO = new CrudDAOImpl<T>();
    }

    @Override
    public void save(T t) {
        crudDAO.save(t);
    }

    @Override
    public void update(T t) {
       crudDAO.update(t);
    }

    @Override
    public void deleteById(Class<T> entityClass, int id) {
        crudDAO.deleteById(entityClass, id);
    }

    @Override
    public T findById(Class<T> entityClass, int id) {
        return crudDAO.findById(entityClass, id);
    }

    @Override
    public List<T> findAll(Class<T> entityClass) {
        return crudDAO.findAll(entityClass);
    }
    
}
