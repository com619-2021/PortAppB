package com.com619.group6.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Model class representing a berth at the port.
 *
 * @author WhitearL
 */
@Entity
public class Berth {
    /**
     * Unique ID for the Berth instance.
     */
    private long id;

    /**
     * Name of the Berth instance.
     */
    private String name;

    /**
     * Public constructor, allow instantiation.
     */
    public Berth() {
    }

    /**
     * ID Property - getter.
     *
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    /**
     * ID Property - setter.
     *
     * @param newId the id to set
     */
    public void setId(final long newId) {
        this.id = newId;
    }

    /**
     * Name property - getter.
     *
     * @return return the current name of the berth
     */
    public String getName() {
        return name;
    }

    /**
     * Name property - setter.
     * @param newName the new name of the berth
     */
    public void setName(final String newName) {
        name = newName;
    }
}
