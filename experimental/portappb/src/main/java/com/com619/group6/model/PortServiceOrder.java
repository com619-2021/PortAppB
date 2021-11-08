package com.com619.group6.model;

import java.util.List;

/**
 * Model class representing a Port Service Order (PSO)
 * 
 * @author WhitearL
 *
 */
public class PortServiceOrder {

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
