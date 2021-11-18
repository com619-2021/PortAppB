package com.com619.group6.model;

/**
 * Model class representing a tariff.
 * 
 * @author WhitearL
 */
public class Tariff {

	private int id;
	private int cost;
	private String description;

	/**
	 * Public constructor, allow instantiation.
	 * 
	 * @param id          ID of tariff
	 * @param cost        Cost of tariff
	 * @param description Description of tariff
	 */
	public Tariff(int id, int cost, String description) {
		this.id = id;
		this.cost = cost;
		this.description = description;
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

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
