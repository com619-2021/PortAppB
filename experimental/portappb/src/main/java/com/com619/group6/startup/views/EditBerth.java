package com.com619.group6.startup.views;

import com.com619.group6.jpadao.DaoFactoryJpa;
import com.com619.group6.model.dao.BerthDao;
import com.com619.group6.model.dao.DaoFactory;
import com.com619.group6.model.Berth;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;

@Route("/berth/edit/:berthId")
public class EditBerth extends Div implements RouterLayout, BeforeEnterObserver {
    BerthDao berthDao;
    Berth originalBerth;
    private long berthId;
    TextField idField = new TextField();
    TextField nameField = new TextField();

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        final RouteParameters urlParameters = beforeEnterEvent.getRouteParameters();

        berthId = Long.parseLong(urlParameters.get("berthId").get());
        DaoFactory factory = new DaoFactoryJpa();
        berthDao = factory.getBerthDao();
        originalBerth = berthDao.getOne(berthId);

        idField.setValue(String.valueOf(originalBerth.getId()));
        idField.setReadOnly(true);
        nameField.setValue(originalBerth.getName());

        FormLayout formLayout = new FormLayout();

        formLayout.addFormItem(idField, "ID");
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
        Berth updatedBerth = new Berth();
        updatedBerth.setId(originalBerth.getId());
        updatedBerth.setName(nameField.getValue());
        berthDao.update(updatedBerth);
    }
}
