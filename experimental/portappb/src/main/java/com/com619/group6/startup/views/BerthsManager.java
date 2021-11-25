package com.com619.group6.startup.views;

import com.com619.group6.jpadao.DaoFactoryJpa;
import com.com619.group6.model.Berth;
import com.com619.group6.model.dao.BerthDao;
import com.com619.group6.model.dao.DaoFactory;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route("berths")
public class BerthsManager extends Div {
    Grid<Berth> grid = new Grid<>(Berth.class, false);
    BerthDao berthDao;

    public BerthsManager() {
        DaoFactory factory = new DaoFactoryJpa();
        berthDao = factory.getBerthDao();
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(getToolbar(), grid);
    }

    private void configureGrid() {
        grid.addColumn(Berth::getId).setHeader("ID");
        grid.addColumn(Berth::getName).setHeader("Name");

        BerthContextMenu contextMenu = new BerthContextMenu(grid);
        grid.setItems(berthDao.getAll());

        add(grid, contextMenu);
    }

    private HorizontalLayout getToolbar() {
        Button addBerthButton = new Button("Add berth");

        addBerthButton.addClickListener(e -> addBerthButton.getUI().ifPresent(ui -> {
            ui.navigate("berths/new");
        }));

        HorizontalLayout toolbar = new HorizontalLayout(addBerthButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private class BerthContextMenu extends GridContextMenu<Berth> {
        public BerthContextMenu(Grid<Berth> target) {
            super(target);

            addItem("Edit", e -> e.getItem().ifPresent(berth -> {
                editBerth(berth.getId());
            }));
            addItem("Delete", e -> e.getItem().ifPresent(berth -> {
                deleteBerth(berth.getId());
            }));
        }
    }

    private void deleteBerth(long berthId) {
        berthDao.deleteOne(berthId);
        grid.setItems(berthDao.getAll());
    }

    private void editBerth(long berthId) {
        UI.getCurrent().navigate("/berth/edit/" + berthId);
    }
}
