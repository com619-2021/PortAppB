package com.com619.group6.model.dao;

import java.util.List;

public interface CommonDao<T> {
    /**
     * Add the passed in entity instance to the persistence database.
     * @param newEntity the new entity to persist
     */
    void create(T newEntity);

    /**
     * Get an entity from the database by entity ID.
     * @param entityId the ID of the entity to retrieve
     * @return An instance of the requested entity if it exists, returns null
     * otherwise
     */
    T getOne(long entityId);

    /**
     * Get an entity from the database by name.
     * @param name the name of the entity to retrieve
     * @return An instance of the requested entity if it exists, returns null
     * otherwise
     */
    T getOne(String name);

    /**
     * Get a list of all the entities in the database.
     * @return List of all entity instances
     */
    List<T> getAll();

    /**
     * Updated the details of an entity.
     * @param details An entity instance with the new details to persist,
     *                ID must be the same as the entity whose details
     *                are to be updated
     */
    void update(T details);

    /**
     * Delete a single entity.
     * @param entityId the ID of the entity to be deleted
     */
    void deleteOne(long entityId);

    /**
     * Delete all entities.
     */
    void deleteAll();
}
