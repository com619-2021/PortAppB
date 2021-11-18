package com.com619.group6.startup.views;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Div;

@Route("some/path")
public class Hello extends Div {
    public Hello() {
        setText("Hello @Route!");
    }
}
