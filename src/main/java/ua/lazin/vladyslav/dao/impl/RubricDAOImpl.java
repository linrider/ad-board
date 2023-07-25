package ua.lazin.vladyslav.dao.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lazin.vladyslav.dao.CrudDAO;
import ua.lazin.vladyslav.entity.Rubric;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RubricDAOImpl implements CrudDAO<Rubric> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Rubric rubric) {
        entityManager.persist(rubric);
    }

    @Override
    public void update(Rubric rubric) {
        Rubric merged = entityManager.merge(rubric);
        entityManager.persist(merged);
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("DELETE FROM Rubric r WHERE r.id =: rId");
        query.setParameter("rId", id);
        query.executeUpdate();
    }

    @Override
    public Rubric findById(int id) {
        return entityManager.find(Rubric.class, id);
    }

    @Override
    public List<Rubric> findAll() {
        TypedQuery<Rubric> query = entityManager.createQuery(
                "FROM Rubric r JOIN FETCH r.ads", Rubric.class);
        return query.getResultList();
    }
}

