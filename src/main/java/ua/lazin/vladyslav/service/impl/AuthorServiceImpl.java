package ua.lazin.vladyslav.service.impl;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lazin.vladyslav.dao.AuthorDAO;
import ua.lazin.vladyslav.dao.impl.AuthorDAOImpl;
import ua.lazin.vladyslav.entity.Author;
import ua.lazin.vladyslav.service.AuthorService;

@Service
@AllArgsConstructor
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
