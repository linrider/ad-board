package ua.lazin.vladyslav.service.impl;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lazin.vladyslav.dao.CrudDAO;
import ua.lazin.vladyslav.dao.impl.AuthorDAOImpl;
import ua.lazin.vladyslav.entity.Author;
import ua.lazin.vladyslav.service.CrudService;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements CrudService<Author> {
    CrudDAO<Author> authorDAO;

    @Override
    public void save(Author author) {
        authorDAO.save(author);
    }

    @Override
    public void update(Author author) {
        authorDAO.update(author);
    }

    @Override
    public void deleteById(int id) {
        authorDAO.deleteById(id);
    }

    @Override
    public Author findById(int id) {
        return authorDAO.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }
}