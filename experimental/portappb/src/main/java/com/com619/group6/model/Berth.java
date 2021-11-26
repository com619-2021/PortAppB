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
     * Unique ID for the Station instance.
     */
    private int id;

	/**
	 * Unique ID for the Station instance.
	 */
	private String name;

	/**
	 * Public constructor, allow instantiation.
	 */
	public Berth() {
	}

	/**
	 * ID Property - getter.
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * ID Property - setter.
	 * @param newId the id to set
	 */
	public void setId(final int newId) {
		this.id = newId;
	}

	/**
	 * Name property - getter.
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(final String newName) {
		name = newName;
	}
}
