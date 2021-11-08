package com.com619.group6.model;

import java.util.List;

/**
 * Model class representing a stevedore
 *
 * @author WhitearL
 *
 */
public class Stevedore {

	private String name;
	private int id;
	private List<PortServiceOrder> assignedPSOs;

	/**
	 * Public constructor, allow instantiation
	 * 
	 * @param name         Name of stevedore
	 * @param id           ID of stevedore
	 * @param assignedPSOs PSOs assigned to stevedore.
	 */
	public Stevedore(String name, int id, List<PortServiceOrder> assignedPSOs) {
		this.name = name;
		this.id = id;
		this.assignedPSOs = assignedPSOs;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the assignedPSOs
	 */
	public List<PortServiceOrder> getAssignedPSOs() {
		return assignedPSOs;
	}

	/**
	 * @param assignedPSOs the assignedPSOs to set
	 */
	public void setAssignedPSOs(List<PortServiceOrder> assignedPSOs) {
		this.assignedPSOs = assignedPSOs;
	}

}
