package com.com619.group6.jpadao;

import com.com619.group6.model.PortService;
import com.com619.group6.model.dao.PortServiceDao;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

public final class PortServiceDaoJpa extends CommonDaoJpa<PortService> implements PortServiceDao {
    /**
     * Public constructor for the StationDAO JPA implementation.
     *
     * @param em Entity manager required for persistence
     */
    @NotNull
    public PortServiceDaoJpa(final EntityManager em) {
        super(em, PortService.class);
    }
}
