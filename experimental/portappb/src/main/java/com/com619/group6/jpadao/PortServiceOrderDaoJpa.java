package com.com619.group6.jpadao;

import com.com619.group6.model.PortServiceOrder;
import com.com619.group6.model.dao.PortServiceOrderDao;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

public final class PortServiceOrderDaoJpa extends CommonDaoJpa<PortServiceOrder> implements PortServiceOrderDao {
    /**
     * Public constructor for the PortServiceOrderDao JPA implementation.
     *
     * @param em Entity manager required for persistence
     */
    @NotNull
    public PortServiceOrderDaoJpa(EntityManager em) {
        super(em, PortServiceOrder.class);
    }
}
