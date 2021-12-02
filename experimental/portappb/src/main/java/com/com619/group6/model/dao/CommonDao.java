package com.com619.group6.model.dao;

import java.util.List;

public interface CommonDao<T> {
    /**
     * Add the passed in berth instance to the persistence database.
     * @param newBerth the new berth to persist
     */
    void create(T newBerth);

    /**
     * Get a berth from the database by berth ID.
     * @param berthId the ID of the berth to retrieve
     * @return An instance of the requested berth if it exists, returns null
     * otherwise
     */
    T getOne(long berthId);

    /**
     * Get a berth from the database by name.
     * @param name the name of the berth to retrieve
     * @return An instance of the requested berth if it exists, returns null
     * otherwise
     */
    T getOne(String name);

    /**
     * Get a list of all the berths in the database.
     * @return List of all berth instances
     */
    List<T> getAll();

    /**
     * Updated the details of a berth.
     * @param details A Berth instance with the new details to persist,
     *                ID must be the same as the berth whose details
     *                are to be updated
     */
    void update(T details);

    /**
     * Delete a single berth.
     * @param berthId the ID of the berth to be deleted
     */
    void deleteOne(long berthId);

    /**
     * Delete all berths.
     */
    void deleteAll();
}
