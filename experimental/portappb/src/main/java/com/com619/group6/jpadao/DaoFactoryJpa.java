package com.com619.group6.jpadao;

import com.com619.group6.model.dao.BerthDao;
import com.com619.group6.model.dao.DaoFactory;
import com.com619.group6.model.dao.PortServiceOrderDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class DaoFactoryJpa implements DaoFactory {
    /**
     * Name of the persistence unit as required by the entity manager.
     */
    private static final String PERSISTENCE_UNIT_NAME = "portAppBPersistence";

    /**
     * DAO singleton used to access data related to the berth entities.
     */
    private static final BerthDao BERTH_DAO;

    /**
     * DAO singleton used to access data related to the port service order
     * entities.
     */
    private static final PortServiceOrderDao PORT_SERVICE_ORDER_DAO;


    static {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        BERTH_DAO = new BerthDaoJpa(em);
        PORT_SERVICE_ORDER_DAO = new PortServiceOrderDaoJpa(em);
    }
    @Override
    public BerthDao getBerthDao() {
        return BERTH_DAO;
    }

    @Override
    public PortServiceOrderDao getPortServiceOrderDao() {
        return PORT_SERVICE_ORDER_DAO;
    }
}
