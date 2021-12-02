package com.com619.group6.jpadao;

import com.com619.group6.model.dao.BerthDao;
import com.com619.group6.model.dao.DaoFactory;
import com.com619.group6.model.dao.PortServiceOrderDao;
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

    /**
     * Check that a PortServiceOrderJpa instance is created when
     * getPortServiceOrderDao() is called.
     */
    @Test
    public void getPortServiceOrderDaoReturnsPortServiceOrderDaoJpaInstance()
    {
        DaoFactory factory = new DaoFactoryJpa();

        PortServiceOrderDao psoDao = factory.getPortServiceOrderDao();

        assertThat(psoDao, instanceOf(PortServiceOrderDaoJpa.class));
    }
}
