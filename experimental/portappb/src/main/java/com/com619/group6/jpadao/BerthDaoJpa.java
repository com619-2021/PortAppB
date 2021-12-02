package com.com619.group6.jpadao;

import com.com619.group6.model.Berth;
import com.com619.group6.model.dao.BerthDao;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

public final class BerthDaoJpa extends CommonDaoJpa<Berth> implements BerthDao {
    /**
     * Public constructor for the StationDAO JPA implementation.
     *
     * @param em Entity manager required for persistence
     */
    @NotNull
    public BerthDaoJpa(final EntityManager em) {
        super(em, Berth.class);
    }
}
