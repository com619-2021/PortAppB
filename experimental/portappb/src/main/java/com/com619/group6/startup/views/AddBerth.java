package com.com619.group6.startup.views;

import com.com619.group6.jpadao.DaoFactoryJpa;
import com.com619.group6.model.Berth;
import com.com619.group6.model.dao.BerthDao;
import com.com619.group6.model.dao.DaoFactory;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;

@Route("/berths/new")
public class AddBerth extends Div {
    BerthDao berthDao;

    TextField nameField = new TextField();

    public AddBerth() {
        DaoFactory factory = new DaoFactoryJpa();
        berthDao = factory.getBerthDao();

        FormLayout formLayout = new FormLayout();

        nameField.setRequired(true);
        formLayout.addFormItem(nameField, "Name");

        add(formLayout, getActionButtons());
    }

    private HorizontalLayout getActionButtons() {
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        cancelButton.addClickListener(e -> cancelButton.getUI().ifPresent(ui -> {
            ui.navigate("berths");
        }));
        saveButton.addClickListener(e -> saveButton.getUI().ifPresent(ui -> {
            saveChanges();
            UI.getCurrent().navigate("/berths");
        }));

        HorizontalLayout buttons = new HorizontalLayout(saveButton, cancelButton);
        buttons.addClassName("action-buttons");
        return buttons;
    }

    private void saveChanges() {
        Berth berth = new Berth();
        berth.setName(nameField.getValue());
        berthDao.create(berth);
    }
}
