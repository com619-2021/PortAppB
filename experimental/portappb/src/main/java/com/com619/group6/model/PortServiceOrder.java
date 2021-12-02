package com.com619.group6.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing a Port Service Order (PSO).
 *
 * @author WhitearL
 */
@Entity
public class PortServiceOrder {
    /**
     * Unique ID for the PortServiceOrder instance.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Name of the PortServiceOrder instance.
     */
    private String name;

    /**
     * List of the required port services.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortService> servicesRequired;

    /**
     * List of the stevedores assigned to the order.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stevedore> assignedStevedores;

    /**
     * Total cost of the service order.
     */
    private double totalCost;

    /**
     * Public constructor, allow instantiation.
     *
     * @param newServicesRequired   Services required for PSO
     * @param newAssignedStevedores Stevedores assigned to PSO
     * @param newTotalCost          Total cost of PSO
     */
    public PortServiceOrder(final List<PortService> newServicesRequired,
                            final List<Stevedore> newAssignedStevedores,
                            final double newTotalCost) {
        servicesRequired = newServicesRequired;
        assignedStevedores = newAssignedStevedores;
        totalCost = newTotalCost;
    }

    /**
     * Public constructor, allow instantiation.
     */
    public PortServiceOrder() {
        this(new ArrayList<PortService>(), new ArrayList<Stevedore>(), 0.0);
    }

    /**
     * ID Property - getter.
     *
     * @return the id
     */
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
     *
     * @param newName the new name of the berth
     */
    public void setName(final String newName) {
        name = newName;
    }

    /**
     * @return the servicesRequired
     */
    public List<PortService> getServicesRequired() {
        return servicesRequired;
    }

    /**
     * @param newServicesRequired the servicesRequired to set
     */
    public void setServicesRequired(
            final List<PortService> newServicesRequired) {
        this.servicesRequired = newServicesRequired;
    }

    /**
     * @return the assignedStevedores
     */
    public List<Stevedore> getAssignedStevedores() {
        return assignedStevedores;
    }

    /**
     * @param newAssignedStevedores the assignedStevedores to set
     */
    public void setAssignedStevedores(
            final List<Stevedore> newAssignedStevedores) {
        assignedStevedores = newAssignedStevedores;
    }

    /**
     * @return the totalCost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * @param newTotalCost the totalCost to set
     */
    public void setTotalCost(final double newTotalCost) {
        totalCost = newTotalCost;
    }
}
