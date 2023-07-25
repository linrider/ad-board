package ua.lazin.vladyslav.dao.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lazin.vladyslav.dao.CrudDAO;
import ua.lazin.vladyslav.entity.Author;

import java.util.List;

import javax.persistence.*;

@Transactional
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDAOImpl implements CrudDAO<Author> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Author author) {
        entityManager.persist(author);
    }

    @Override
    public void update(Author author) {
        Author merged = entityManager.merge(author);
        entityManager.persist(merged);
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("DELETE FROM Author a WHERE a.id =: aId");
        query.setParameter("aId", id);
        query.executeUpdate();
    }

    @Override
    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public List<Author> findAll() {
        TypedQuery<Author> query = entityManager.createQuery(
                "FROM Author a " +
                        "JOIN FETCH a.phones ",
                Author.class);
        return query.getResultList();
    }
}
