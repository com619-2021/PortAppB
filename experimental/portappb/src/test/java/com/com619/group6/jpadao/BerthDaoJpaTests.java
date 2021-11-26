package com.com619.group6.jpadao;

import com.com619.group6.model.Berth;
import com.com619.group6.model.dao.BerthDao;
import com.com619.group6.model.dao.DaoFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BerthDaoJpaTests {
    /*
     *  These tests are not strictly unit tests as we are testing
     *  that berth instances are being persisted to the disk rather
     *  than mocking the entity manager responsible and checking that
     *  it is being used correctly. As a result these tests are relatively
     *  slow
     */

    /**
     * Berth name used for test purposes, specific value is unimportant.
     */
    private static final String SOME_NAME = "Some name";

    /**
     * 0 items in a list.
     */
    private static final int ZERO_ITEMS = 0;
    /**
     * 2 items in a list.
     */
    private static final int TWO_ITEMS = 2;

    /**
     * Used to hold a reference to the berthDao instance being tested.
     */
    private BerthDao berthDao;

    /**
     * Setup used to initialise the test environment before each test case.
     * - Initialises the berthDao instance to be tested
     * - Removes all the berths from the persistence database
     */
    @Before
    public void setup()
    {
        // Remove everything from the database before each test to ensure that
        // each unit test is as atomic as possible
        DaoFactory factory = new DaoFactoryJpa();
        berthDao = factory.getBerthDao();
        berthDao.deleteAll();
    }

    /**
     * Check that the addBerth method saves the passed in berth to the database.
     */
    @Test
    public void createBerthAddsPassedInBerthToPersistenceDatabase()
    {
        Berth testBerth = new Berth();
        testBerth.setName(SOME_NAME);

        berthDao.create(testBerth);

        List<Berth> stationList = berthDao.getAll();
        assertThat(stationList, hasItem(testBerth));
    }

    /**
     * Check that the persisted Stations can be retrieved from the database.
     */
    @Test
    public void getAllReturnsListOfAllAddedBerths()
    {
        // We need to create 2 station instances because if we add the same instance
        // twice the persistence layer treats it as the same item, and we only get
        // one item in the database
        Berth testBerth = new Berth();
        berthDao.create(testBerth);
        testBerth = new Berth();
        berthDao.create(testBerth);

        List<Berth> berthList = berthDao.getAll();
        assertThat(berthList.size(), equalTo(TWO_ITEMS));
    }

    /**
     * Check that all stations can be removed from the persistence database.
     */
    @Test
    public void deleteAllRemovesAllStationsFromTheDatabase()
    {
        Berth testBerth = new Berth();
        berthDao.create(testBerth);
        testBerth = new Berth();
        berthDao.create(testBerth);

        berthDao.deleteAll();

        List<Berth> berthList = berthDao.getAll();
        assertThat(berthList.size(), equalTo(ZERO_ITEMS));
    }
}
