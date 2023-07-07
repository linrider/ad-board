package ua.lazin.vladyslav.dao.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lazin.vladyslav.dao.AuthorDAO;
import ua.lazin.vladyslav.dao.CrudDAO;
import ua.lazin.vladyslav.entity.Author;

import java.util.List;

import javax.persistence.*;

import static ua.lazin.vladyslav.dao.CrudDAO.FACTORY;

@Transactional
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDAOImpl implements AuthorDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Author> findAll() {

        TypedQuery<Author> query = entityManager.createQuery(
                "FROM Author a JOIN FETCH a.phones JOIN FETCH a.address JOIN FETCH a.email",
                Author.class);
        List<Author> result = query.getResultList();

        return result;

    }
}
