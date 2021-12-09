package com.com619.group6.startup.views;

import com.com619.group6.jpadao.DaoFactoryJpa;
import com.com619.group6.model.PortService;
import com.com619.group6.model.dao.PortServiceDao;
import com.com619.group6.model.dao.DaoFactory;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("port-services")
public class PortServicesManager extends Div {
    Grid<PortService> grid = new Grid<>(PortService.class, false);
    PortServiceDao portServiceDao;

    public PortServicesManager() {
        DaoFactory factory = new DaoFactoryJpa();
        portServiceDao = factory.getPortServiceDao();
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(getToolbar(), grid);
    }

    private void configureGrid() {
        grid.addColumn(PortService::getId).setHeader("ID");
        //grid.addColumn(PortService::getName).setHeader("Name");
        grid.addColumn(PortService::getServiceType).setHeader("Service Type");
        grid.addColumn(PortService::getCost).setHeader("Cost");

        PortServiceContextMenu contextMenu = new PortServiceContextMenu(grid);
        grid.setItems(portServiceDao.getAll());

        add(grid, contextMenu);
    }

    private HorizontalLayout getToolbar() {
        Button addPortServiceButton = new Button("Add service");

        addPortServiceButton.addClickListener(e -> addPortServiceButton.getUI().ifPresent(ui -> {
            ui.navigate("port-services/new");
        }));

        HorizontalLayout toolbar = new HorizontalLayout(addPortServiceButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private class PortServiceContextMenu extends GridContextMenu<PortService> {
        public PortServiceContextMenu(Grid<PortService> target) {
            super(target);

            addItem("Edit", e -> e.getItem().ifPresent(portService -> {
                editPortService(portService.getId());
            }));
            addItem("Delete", e -> e.getItem().ifPresent(portService -> {
                deletePortService(portService.getId());
            }));
        }
    }

    private void deletePortService(long portServiceId) {
        portServiceDao.deleteOne(portServiceId);
        grid.setItems(portServiceDao.getAll());
    }

    private void editPortService(long portServiceId) {
        UI.getCurrent().navigate("/port-service/edit/" + portServiceId);
    }
}
