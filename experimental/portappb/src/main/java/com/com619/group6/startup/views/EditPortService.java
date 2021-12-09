package com.com619.group6.startup.views;

import com.com619.group6.jpadao.DaoFactoryJpa;
import com.com619.group6.model.PortService;
import com.com619.group6.model.ServiceType;
import com.com619.group6.model.dao.PortServiceDao;
import com.com619.group6.model.dao.DaoFactory;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;

@Route("/port-service/edit/:portServiceId")
public class EditPortService extends Div implements RouterLayout, BeforeEnterObserver {
    PortServiceDao portServiceDao;
    PortService originalPortService;
    private long portServiceId;

    TextField idField = new TextField();
    //TextField nameField = new TextField();
    TextField serviceTypeField = new TextField();
    NumberField costField = new NumberField();

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        final RouteParameters urlParameters = beforeEnterEvent.getRouteParameters();

        portServiceId = Long.parseLong(urlParameters.get("portServiceId").get());
        DaoFactory factory = new DaoFactoryJpa();
        portServiceDao = factory.getPortServiceDao();
        originalPortService = portServiceDao.getOne(portServiceId);

        idField.setValue(String.valueOf(originalPortService.getId()));
        idField.setReadOnly(true);
        //nameField.setValue(originalPortService.getName());
        ServiceType pst = originalPortService.getServiceType();
        if (pst != null) {
            serviceTypeField.setValue(originalPortService.getServiceType().toString());
        }
        costField.setValue(originalPortService.getCost());

        FormLayout formLayout = new FormLayout();

        formLayout.addFormItem(idField, "ID");
        //formLayout.addFormItem(nameField, "Name");
        formLayout.addFormItem(serviceTypeField, "ServiceType");
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
        PortService updatedPortService = new PortService();
        updatedPortService.setId(originalPortService.getId());
        //updatedPortService.setName(nameField.getValue());
        //updatedPortService.setServiceType(serviceTypeField.getValue());
        updatedPortService.setCost(costField.getValue());
        portServiceDao.update(updatedPortService);
    }
}
