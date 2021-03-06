package com.com619.group6.jpadao;

import com.com619.group6.model.dao.CommonDao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * Abstract DAO class that provides basic CRUD operations.
 *
 * @param <T>
 */
public abstract class CommonDaoJpa<T> implements CommonDao<T> {
    /**
     * The class type of the entity the DAO instance is against.
     */
    private final Class<T> typeParameterClass;

    /**
     * Entity manager used for persistence.
     */
    private final EntityManager entityManager;

    /**
     * Public constructor for the PortServiceOrderDao JPA implementation.
     *
     * @param em        Entity manager required for persistence
     * @param classType the type of the class representing the entity T
     */
    @NotNull
    public CommonDaoJpa(final EntityManager em, final Class<T> classType) {
        entityManager = em;
        typeParameterClass = classType;
    }

    @Override
    public final void create(final T newEntity) {
        entityManager.getTransaction()
                .begin();
        entityManager.persist(newEntity);
        entityManager.getTransaction()
                .commit();
    }

    @Override
    public final T getOne(final long entityId) {
        TypedQuery<T> q = entityManager.createQuery(
                        "SELECT e FROM " + typeParameterClass.getSimpleName()
                                + " e WHERE e.id=:id", typeParameterClass)
                .setParameter("id", entityId);
        return runGetEntityQuery(q);
    }

    @Override
    public final T getOne(final String name) {
        TypedQuery<T> q = entityManager.createQuery(
                        "SELECT e FROM " + typeParameterClass.getSimpleName()
                                + " e WHERE e.name=:name", typeParameterClass)
                .setParameter("name", name);
        return runGetEntityQuery(q);
    }

    @Override
    public final List<T> getAll() {
        TypedQuery<T> q = entityManager.createQuery("SELECT e FROM "
                        + typeParameterClass.getSimpleName() + " e",
                typeParameterClass);
        return q.getResultList();
    }

    @Override
    public final void update(final T details) {
        entityManager.merge(details);
    }

    @Override
    public final void deleteOne(final long entityId) {
        entityManager.getTransaction()
                .begin();
        entityManager.createQuery("DELETE FROM "
                        + typeParameterClass.getSimpleName()
                        + " e WHERE e.id=:id")
                .setParameter("id", entityId)
                .executeUpdate();
        entityManager.getTransaction()
                .commit();
    }

    @Override
    public final void deleteAll() {
        entityManager.getTransaction()
                .begin();
        entityManager.createQuery("DELETE FROM "
                        + typeParameterClass.getSimpleName())
                .executeUpdate();
        entityManager.getTransaction()
                .commit();
    }

    protected final T runGetEntityQuery(final TypedQuery<T> q) {
        T result;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            result = null;
        }
        return result;
    }
}
