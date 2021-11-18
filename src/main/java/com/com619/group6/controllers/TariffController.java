package com.com619.group6.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.com619.group6.model.Tariff;

/**
 * Rest controller for tariffs.
 *
 * @author WhitearL
 */
@RestController
public class TariffController {

	/**
	 * Create a new tariff
	 * 
	 * @return Boolean indicating success
	 */
	@GetMapping(value = "/createTariff")
	public boolean createTariff(/* TODO: Params? */) {

		return true;
	}

	/**
	 * Edit an existing tariff
	 * 
	 * @param tariffID ID of the tariff to edit.
	 * 
	 * @return Boolean indicating success
	 */
	@GetMapping(value = "/editTariff")
	public boolean editTariff(@RequestParam(required = true) int tariffID) {

		return true;
	}

	/**
	 * Delete an existing tariff
	 * 
	 * @param tariffID ID of the tariff to delete.
	 * 
	 * @return Boolean indicating success
	 */
	@GetMapping(value = "/deleteTariff")
	public boolean deleteTariff(@RequestParam(required = true) int tariffID) {

		return true;
	}

	/**
	 * Retrieve all applicable tariffs for a given ship
	 * 
	 * @param shipID  ID of the ship
	 * @param berthID ID of the berth the ship is at
	 * 
	 * @return List of tariffs that apply to the given ship
	 */
	@GetMapping(value = "/getApplicableTariffs")
	public List<Tariff> getApplicableTariffs(@RequestParam(required = true) int shipID,
			@RequestParam(required = true) int berthID /* TODO: Include PSOs? */) {

		return new ArrayList<>();
	}

	/**
	 * Calculate the total of all tariffs for a given ship.
	 * 
	 * @param shipID  ID of the ship
	 * @param berthID ID of the berth the ship is at
	 * 
	 * @return Total cost from tariffs.
	 */
	@GetMapping(value = "/calculateTotalCost")
	public double calculateTotalCost(@RequestParam(required = true) int shipID,
			@RequestParam(required = true) int berthID /* TODO: Include PSOs? */) {

		return 1;
	}

}
