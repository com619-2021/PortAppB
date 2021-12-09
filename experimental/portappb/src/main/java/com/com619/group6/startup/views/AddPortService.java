package com.com619.group6.startup.views;

import com.com619.group6.jpadao.DaoFactoryJpa;
import com.com619.group6.model.PortService;
import com.com619.group6.model.dao.PortServiceDao;
import com.com619.group6.model.dao.DaoFactory;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/port-services/new")
public class AddPortService extends Div {
    private PortServiceDao portServiceDao;

    //TextField nameField = new TextField();
    TextField serviceTypeField = new TextField();
    NumberField costField = new NumberField();

    public AddPortService() {
        DaoFactory factory = new DaoFactoryJpa();
        portServiceDao = factory.getPortServiceDao();

        FormLayout formLayout = new FormLayout();

        //nameField.setRequired(true);
        //formLayout.addFormItem(nameField, "Name");

        serviceTypeField.setRequired(true);
        formLayout.addFormItem(serviceTypeField, "Service Type");

        Div costPrefix = new Div();
        costPrefix.setText("£");
        costField.setPrefixComponent(costPrefix);
        costField.setStep(0.01);
        costField.setMin(0);
        formLayout.addFormItem(costField, "Cost");

        add(formLayout, getActionButtons());
    }

    private HorizontalLayout getActionButtons() {
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        cancelButton.addClickListener(e -> cancelButton.getUI().ifPresent(ui -> {
            ui.navigate("port-services");
        }));
        saveButton.addClickListener(e -> saveButton.getUI().ifPresent(ui -> {
            saveChanges();
            UI.getCurrent().navigate("/port-services");
        }));

        HorizontalLayout buttons = new HorizontalLayout(saveButton, cancelButton);
        buttons.addClassName("action-buttons");
        return buttons;
    }

    private void saveChanges() {
        PortService portService = new PortService();
        //portService.setName(nameField.getValue());
        //portService.setServiceType(serviceTypeField.getValue());
        portService.setCost(costField.getValue());
        portServiceDao.create(portService);
    }
}
