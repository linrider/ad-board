package ua.lazin.vladyslav.dao;

import java.util.List;

public interface CrudDAO<T> {
    public void save(T t);

    void update(T t);

    void deleteById(int id);

    T findById(int id);

    List<T> findAll();

}
