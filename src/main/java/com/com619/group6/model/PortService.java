package com.com619.group6.model;

/**
 * Model class representing a service as part of a PSO.
 * 
 * @author WhitearL
 *
 */
public class PortService {

	private int id;
	private ServiceType serviceType;
	private double cost;

	/**
	 * Public constructor, allow instantiation
	 * 
	 * @param id          ID of this service
	 * @param serviceType Type of service this is
	 * @param cost        The cost of this service.
	 */
	public PortService(int id, ServiceType serviceType, double cost) {
		this.id = id;
		this.serviceType = serviceType;
		this.cost = cost;
	}

	/**
	 * @return the serviceType
	 */
	public ServiceType getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
