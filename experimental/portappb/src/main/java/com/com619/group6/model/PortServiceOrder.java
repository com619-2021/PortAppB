package com.com619.group6.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing a Port Service Order (PSO)
 * 
 * @author WhitearL
 *
 */
@Entity
public class PortServiceOrder {
	/**
	 * Unique ID for the PortServiceOrder instance.
	 */
	private long id;

	/**
	 * Name of the PortServiceOrder instance.
	 */
	private String name;

	private List<PortService> servicesRequired;
	private List<Stevedore> assignedStevedores;
	private double totalCost;

	/**
	 * Public constructor, allow instantiation
	 * 
	 * @param servicesRequired   Services required for PSO
	 * @param assignedStevedores Stevedores assigned to PSO
	 * @param totalCost          Total cost of PSO
	 */
	public PortServiceOrder(List<PortService> servicesRequired, List<Stevedore> assignedStevedores, double totalCost) {
		this.servicesRequired = servicesRequired;
		this.assignedStevedores = assignedStevedores;
		this.totalCost = totalCost;
	}

	public PortServiceOrder() {
		this(new ArrayList<PortService>(), new ArrayList<Stevedore>(), 0.0);
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

	/**
	 * @return the servicesRequired
	 */
	public List<PortService> getServicesRequired() {
		return servicesRequired;
	}

	/**
	 * @param servicesRequired the servicesRequired to set
	 */
	public void setServicesRequired(List<PortService> servicesRequired) {
		this.servicesRequired = servicesRequired;
	}

	/**
	 * @return the assignedStevedores
	 */
	public List<Stevedore> getAssignedStevedores() {
		return assignedStevedores;
	}

	/**
	 * @param assignedStevedores the assignedStevedores to set
	 */
	public void setAssignedStevedores(List<Stevedore> assignedStevedores) {
		this.assignedStevedores = assignedStevedores;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
}
