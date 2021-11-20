package com.com619.group6.startup.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("some/path")
public class Hello extends Div {
	private static final long serialVersionUID = 675305197369382530L;

	public Hello() {
		setText("Hello @Route!");
	}
}
