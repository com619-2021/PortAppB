package com.com619.group6.model;

import javax.persistence.*;
import java.util.List;

/**
 * Model class representing a stevedore
 *
 * @author WhitearL
 *
 */
@Entity
public class Stevedore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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

	public Stevedore() {
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
	public long getId() {
		return id;
	}

	/**
	 * @param newId the id to set
	 */
	public void setId(long newId) {
		id = newId;
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
