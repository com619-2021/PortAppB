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
	 * Public constructor, allow instantiation.
	 * 
	 * @param id ID of Berth
	 */
	public Berth(int id) {
		this.id = id;
	}

	/**
	 * Public constructor, allow instantiation.
	 */
	public Berth() {
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * @param newId the id to set
	 */
	public void setId(int newId) {
		this.id = newId;
	}
}
