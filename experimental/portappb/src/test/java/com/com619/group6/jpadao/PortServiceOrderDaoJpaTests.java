package com.com619.group6.jpadao;

import com.com619.group6.model.PortServiceOrder;
import com.com619.group6.model.dao.DaoFactory;
import com.com619.group6.model.dao.PortServiceOrderDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class PortServiceOrderDaoJpaTests {
    /**
     * Port Service Order name used for test purposes, specific value is
     * unimportant.
     */
    private static final String SOME_NAME = "Some name";

    /**
     * Used to hold a reference to the berthDao instance being tested.
     */
    private PortServiceOrderDao psoDao;

    /**
     * Setup used to initialise the test environment before each test case.
     * - Initialises the berthDao instance to be tested
     * - Removes all the berths from the persistence database
     */
    @BeforeEach
    public void setup()
    {
        // Remove everything from the database before each test to ensure that
        // each unit test is as atomic as possible
        DaoFactory factory = new DaoFactoryJpa();
        psoDao = factory.getPortServiceOrderDao();
        psoDao.deleteAll();
    }

    /**
     * Check that the addBerth method saves the passed in berth to the database.
     */
    @Test
    public void createBerthAddsPassedInBerthToPersistenceDatabase()
    {
        PortServiceOrder testPso = new PortServiceOrder();
        testPso.setName(SOME_NAME);

        psoDao.create(testPso);

        List<PortServiceOrder> psoList = psoDao.getAll();
        assertThat(psoList, hasItem(testPso));
    }
}
