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
     * Berth name used for test purposes, name helps identify specific instance.
     */
    private static final String BERTH_1 = "Berth 1";
    /**
     * Berth name used for test purposes, name helps identify specific instance.
     */
    private static final String BERTH_2 = "Berth 2";

    /**
     * ID number used for testing purposes, specific value is unimportant.
     */
    private static final long SOME_ID = 123;

    /**
     * 0 items in a list.
     */
    private static final int ZERO_ITEMS = 0;
    /**
     * 2 items in a list.
     */
    private static final int TWO_ITEMS = 2;

    /**
     * Index of the first item in a list.
     */
    private static final int FIRST_ITEM = 0;

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

        List<Berth> berthList = berthDao.getAll();
        assertThat(berthList, hasItem(testBerth));
    }

    /**
     * Check that the persisted berths can be retrieved from the database.
     */
    @Test
    public void getAllReturnsListOfAllAddedBerths()
    {
        // We need to create 2 berth instances because if we add the same instance
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
     * Check that all berths can be removed from the persistence database.
     */
    @Test
    public void deleteAllRemovesAllBerthsFromTheDatabase()
    {
        Berth testBerth = new Berth();
        berthDao.create(testBerth);
        testBerth = new Berth();
        berthDao.create(testBerth);

        berthDao.deleteAll();

        List<Berth> berthList = berthDao.getAll();
        assertThat(berthList.size(), equalTo(ZERO_ITEMS));
    }

    /**
     * Check that only the berth with the specified ID is removed from the database.
     */
    @Test
    public void deleteRemovesBerthWithPassedInIdFromTheDatabase()
    {
        Berth testBerth = new Berth();
        testBerth.setName(BERTH_1);
        berthDao.create(testBerth);
        testBerth = new Berth();
        testBerth.setName(BERTH_2);
        berthDao.create(testBerth);

        testBerth = berthDao.getAll()
                .get(FIRST_ITEM);
        berthDao.deleteOne(testBerth.getId());

        List<Berth> berthList = berthDao.getAll();
        assertThat(berthList, not(hasItem(testBerth)));
    }

    /**
     * Check that a berth is correctly retrieved by name when one exists.
     */
    @Test
    public void getOneRetrievesBerthWithPassedInNameFromDatabase()
    {
        Berth testBerth = new Berth();
        testBerth.setName(BERTH_1);
        berthDao.create(testBerth);

        Berth berth = berthDao.getOne(BERTH_1);

        assertThat(berth.getName(), equalTo(BERTH_1));
    }

    /**
     * Check that null is returned if the requested berth doesn't exist.
     */
    @Test
    public void getBerthReturnsNullIfNoMatchFoundForName()
    {
        Berth berth = berthDao.getOne(BERTH_1);

        assertThat(berth, nullValue());
    }

    /**
     * Check that a berth is correctly retrieved by id when one exists.
     */
    @Test
    public void getBerthRetrievesBerthWithPassedInIdFromDatabase()
    {
        Berth testBerth = new Berth();
        testBerth.setName(BERTH_1);
        berthDao.create(testBerth);
        long id = berthDao.getOne(BERTH_1).getId();

        Berth berth = berthDao.getOne(id);

        assertThat(berth.getName(), equalTo(BERTH_1));
    }

    /**
     * Check that null is returned if the requested berth doesn't exist.
     */
    @Test
    public void getBerthReturnsNullIfNoMatchFoundForId()
    {
        Berth berth = berthDao.getOne(SOME_ID);

        assertThat(berth, nullValue());
    }

    /**
     * Check that we can update the name of a berth that has been persisted.
     */
    @Test
    public void updateBerthSetsBerthNameToPassedInBerthName()
    {
        Berth testBerth = new Berth();
        testBerth.setName(BERTH_1);
        berthDao.create(testBerth);
        long id = berthDao.getOne(BERTH_1)
                .getId();
        
        // We create a new berth instance and set the appropriate properties
        // rather than retrieve the berth with the required ID and modify that
        // as modifying the retrieved berth also modifies the instance which
        // was originally persisted.
        Berth newDetails = new Berth();
        newDetails.setId(id);
        newDetails.setName(BERTH_2);

        berthDao.update(newDetails);
        Berth updatedBerth = berthDao.getOne(id);
        assertThat(updatedBerth.getName(), equalTo(BERTH_2));
    }
}
