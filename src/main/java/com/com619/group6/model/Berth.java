package com.com619.group6.model;

/**
 * Model class representing a berth at the port.
 * 
 * @author WhitearL
 */
public class Berth {

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
