package ua.lazin.vladyslav.dao;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

public interface CrudDAO<T> {
    public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("holsteng");

    public default void save(T t) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(t);

        transaction.commit();
        entityManager.close();
    }

    public default void update(T t) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        T merged = entityManager.merge(t);

        entityManager.persist(merged);

        transaction.commit();
        entityManager.close();
    }

    public default void deleteById(Class<T> entityClass, int id) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String entityName = entityClass.getSimpleName();
        String queryString = "DELETE FROM " + entityName + " e WHERE e.id =: eId";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("eId", id);
        query.executeUpdate();

        transaction.commit();
        entityManager.close();
    }

    public default T findById(Class<T> entityClass, int id) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        T t = entityManager.find(entityClass, id);

        transaction.commit();
        entityManager.close();
        return t;
    }

    public default List<T> findAll(Class<T> entityClass) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String className = entityClass.getSimpleName();

        TypedQuery<T> query = entityManager.createQuery("FROM ".concat(className), entityClass);
        List<T> result = query.getResultList();

        transaction.commit();
        entityManager.close();
        return result;
    }

}
