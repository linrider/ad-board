package ua.lazin.vladyslav.service.impl;

import java.util.List;

import ua.lazin.vladyslav.dao.AuthorDAO;
import ua.lazin.vladyslav.dao.impl.AuthorDAOImpl;
import ua.lazin.vladyslav.entity.Author;
import ua.lazin.vladyslav.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
    AuthorDAO authorDAO;

    public AuthorServiceImpl() {
        authorDAO = new AuthorDAOImpl();
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }
}
