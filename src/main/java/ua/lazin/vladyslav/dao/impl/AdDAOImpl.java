package ua.lazin.vladyslav.dao.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lazin.vladyslav.dao.CrudDAO;
import ua.lazin.vladyslav.entity.Ad;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdDAOImpl implements CrudDAO<Ad> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Ad ad) {
        entityManager.persist(ad);
    }

    @Override
    public void update(Ad ad) {
        Ad merged = entityManager.merge(ad);
        entityManager.persist(merged);
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("DELETE FROM Ad ad WHERE ad.id =: adId");
        query.setParameter("adId", id);
        query.executeUpdate();
    }

    @Override
    public Ad findById(int id) {
        return entityManager.find(Ad.class, id);
    }

    @Override
    public List<Ad> findAll() {
        TypedQuery<Ad> query = entityManager.createQuery("FROM Ad ad", Ad.class);
        return query.getResultList();
    }
}
