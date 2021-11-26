package com.com619.group6.jpadao;

import com.com619.group6.model.dao.BerthDao;
import com.com619.group6.model.dao.DaoFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class DaoFactoryJpa implements DaoFactory {
    /**
     * Name of the persistence unit as required by the entity manager.
     */
    private static final String PERSISTENCE_UNIT_NAME = "portAppBPersistence";

    /**
     * Factory used to create the entity manager used to persist the DAO entities.
     */
    private static EntityManagerFactory factory = null;

    /**
     * Entity manager used to persist the DAO entities.
     */
    private static EntityManager em = null;

    /**
     * DAO singleton used to access data related to the berth entities.
     */
    private static BerthDao berthDao;

    static {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        berthDao = new BerthDaoJpa(em);
    }
    @Override
    public BerthDao getBerthDao() {
        return berthDao;
    }
}
