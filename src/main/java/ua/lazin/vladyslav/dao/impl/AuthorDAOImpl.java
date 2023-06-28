package ua.lazin.vladyslav.dao.impl;

import ua.lazin.vladyslav.dao.AuthorDAO;
import ua.lazin.vladyslav.dao.CrudDAO;
import ua.lazin.vladyslav.entity.Author;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import static ua.lazin.vladyslav.dao.CrudDAO.FACTORY;

public class AuthorDAOImpl implements AuthorDAO {

    @Override
    public List<Author> findAll() {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Author> query = entityManager.createQuery(
                "FROM Author a JOIN FETCH a.phones JOIN FETCH a.address JOIN FETCH a.email",
                Author.class);
        List<Author> result = query.getResultList();

        transaction.commit();
        entityManager.close();
        return result;

    }
}
