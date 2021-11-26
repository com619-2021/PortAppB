package com.com619.group6.jpadao;

import com.com619.group6.model.dao.BerthDao;
import com.com619.group6.model.dao.DaoFactory;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class DaoFactoryJpaTests {
    /**
     * Check that a BerthDaoJpa instance is created when getBerthDao() is called.
     */
    @Test
    public void getBerthDaoReturnsBerthDaoJpaInstance()
    {
        DaoFactory factory = new DaoFactoryJpa();

        BerthDao berthDao = factory.getBerthDao();

        assertThat(berthDao, instanceOf(BerthDaoJpa.class));
    }
}
