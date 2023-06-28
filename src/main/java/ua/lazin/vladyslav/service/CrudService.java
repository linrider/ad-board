package ua.lazin.vladyslav.service;

import java.util.List;

public interface CrudService<T> {
    public void save(T t);

    public void update(T t);

    public void deleteById(Class<T> entityClass, int id);

    public T findById(Class<T> entityClass, int id);

    public List<T> findAll(Class<T> entityClass);
}
