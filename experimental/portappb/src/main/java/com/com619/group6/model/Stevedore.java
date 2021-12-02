package com.com619.group6.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Model class representing a stevedore.
 *
 * @author WhitearL
 */
@Entity
public class Stevedore {
    /**
     * Unique ID for the Stevedore instance.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Name of the Stevedore instance.
     */
    private String name;

    /**
     * List of orders that the stevedore is assigned to.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortServiceOrder> assignedPSOs;

    /**
     * Public constructor, allow instantiation.
     *
     * @param newName         Name of stevedore
     * @param newId           ID of stevedore
     * @param newAssignedPSOs PSOs assigned to stevedore
     */
    public Stevedore(final String newName, final long newId,
                     final List<PortServiceOrder> newAssignedPSOs) {
        name = newName;
        id = newId;
        assignedPSOs = newAssignedPSOs;
    }

    /**
     * Public constructor, allow instantiation.
     */
    public Stevedore() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param newName the name to set
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param newId the id to set
     */
    public void setId(final long newId) {
        id = newId;
    }

    /**
     * @return the assignedPSOs
     */
    public List<PortServiceOrder> getAssignedPSOs() {
        return assignedPSOs;
    }

    /**
     * @param newAssignedPSOs the assignedPSOs to set
     */
    public void setAssignedPSOs(final List<PortServiceOrder> newAssignedPSOs) {
        this.assignedPSOs = newAssignedPSOs;
    }
}
