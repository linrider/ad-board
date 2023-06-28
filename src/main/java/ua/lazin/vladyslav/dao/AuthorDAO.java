package ua.lazin.vladyslav.dao;

import java.util.List;

import ua.lazin.vladyslav.entity.Author;

public interface AuthorDAO extends CrudDAO<Author> {
    
    List<Author> findAll();
}
