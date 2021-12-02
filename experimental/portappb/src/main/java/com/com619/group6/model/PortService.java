package com.com619.group6.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Model class representing a service as part of a PSO.
 *
 * @author WhitearL
 */
@Entity
public class PortService {
    /**
     * Unique ID for the PortService instance.
     */
    private long id;

    /**
     * Name of the PortService instance.
     */
    private String name;

    /**
     * What category the port service is.
     */
    private ServiceType serviceType;

    /**
     * Cost of the port service.
     */
    private double cost;

    /**
     * Public constructor, allow instantiation.
     *
     * @param newId          ID of this service
     * @param newServiceType Type of service this is
     * @param newCost        The cost of this service.
     */
    public PortService(final int newId, final ServiceType newServiceType,
                       final double newCost) {
        id = newId;
        serviceType = newServiceType;
        cost = newCost;
    }

    /**
     * Public constructor, allow instantiation.
     */
    public PortService() {
    }

    /**
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
        id = newId;
    }

    /**
     * @return the serviceType
     */
    public ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * @param newServiceType the serviceType to set
     */
    public void setServiceType(final ServiceType newServiceType) {
        this.serviceType = newServiceType;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param newCost the cost to set
     */
    public void setCost(final double newCost) {
        this.cost = newCost;
    }
}
