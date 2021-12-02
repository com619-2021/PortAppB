package com.com619.group6.model.dao;

public interface DaoFactory {
    /**
     * Get a reference to the berth DAO.
     * @return an instance of the berth DAO
     */
    BerthDao getBerthDao();

    /**
     * Get a reference to the port service DAO.
     * @return an instance of the port service DAO
     */
    PortServiceDao getPortServiceDao();

    /**
     * Get a reference to the port service order DAO.
     * @return an instance of the port service order DAO
     */
    PortServiceOrderDao getPortServiceOrderDao();
}
