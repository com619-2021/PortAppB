package com.com619.group6.startup.uiservices;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class GreetService implements Serializable {

	private static final long serialVersionUID = -2459560286070004454L;

	public String greet(String name) {
		if (name == null || name.isEmpty()) {
			return "Hello anonymous user";
		} else {
			return "Hello " + name;
		}
	}

}
