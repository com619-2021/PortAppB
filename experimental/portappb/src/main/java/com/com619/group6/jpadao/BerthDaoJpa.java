package com.com619.group6.jpadao;

import com.com619.group6.model.Berth;
import com.com619.group6.model.dao.BerthDao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

public final class BerthDaoJpa implements BerthDao {
    /**
     * Entity manager used for persistence.
     */
    private final EntityManager entityManager;

    /**
     * Public constructor for the StationDAO JPA implementation.
     *
     * @param em Entity manager required for persistence
     */
    @NotNull
    public BerthDaoJpa(final EntityManager em) {
        entityManager = em;
    }

    @Override
    public void create(final Berth newBerth) {
        entityManager.getTransaction()
                .begin();
        entityManager.persist(newBerth);
        entityManager.getTransaction()
                .commit();
    }

    @Override
    public List<Berth> getAll() {
        TypedQuery<Berth> q = entityManager.createQuery("SELECT b FROM Berth b",
                Berth.class);
        return q.getResultList();
    }

    @Override
    public Berth getOne(final long berthId) {
        TypedQuery<Berth> q = entityManager.createQuery(
                        "SELECT b FROM Berth b WHERE b.id=:id", Berth.class)
                .setParameter("id", berthId);
        return runGetBerthQuery(q);
    }

    @Override
    public Berth getOne(final String name) {
        TypedQuery<Berth> q = entityManager.createQuery(
                        "SELECT b FROM Berth b WHERE b.name=:name", Berth.class)
                .setParameter("name", name);
        return runGetBerthQuery(q);
    }

    @Override
    public void update(final Berth details) {
        entityManager.merge(details);
    }

    @Override
    public void deleteOne(final long berthId) {
        entityManager.getTransaction()
                .begin();
        entityManager.createQuery("DELETE FROM Berth b WHERE b.id=:id")
                .setParameter("id", berthId)
                .executeUpdate();
        entityManager.getTransaction()
                .commit();
    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction()
                .begin();
        entityManager.createQuery("DELETE FROM Berth")
                .executeUpdate();
        entityManager.getTransaction()
                .commit();
    }

    private Berth runGetBerthQuery(final TypedQuery<Berth> q) {
        Berth result;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            result = null;
        }
        return result;
    }
}
