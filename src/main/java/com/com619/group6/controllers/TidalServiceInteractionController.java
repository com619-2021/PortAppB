package com.com619.group6.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for passthrough interaction with tidal information service.
 * 
 * @author WhitearL
 */
@RestController
public class TidalServiceInteractionController {

	/**
	 * Get the height of the tide at the port. Optionally accepts time. If time not
	 * supplied then will check tide height at time of request.
	 * 
	 * @param time Time to check tide height (optional)
	 * @return Integer tide height in meters
	 */
	@GetMapping(value = "/getTideHeight")
	public int getTideHeight(@RequestParam(required = false) LocalDateTime time) {

		return 1;
	}

	/**
	 * Is the height of the tide acceptable? Optionally accepts time. If time not
	 * supplied then will check tide height at time of request.
	 * 
	 * @TODO: Accept ship info? Different ships have different displacements so some
	 *        ships might be ok in high tide.
	 * @param time Time to check tide height (optional)
	 * @return boolean indicating whether tide is acceptable
	 */
	@GetMapping(value = "/isOkTideHeight")
	public boolean isOkTideHeight(@RequestParam(required = false) LocalDateTime time) {

		return true;
	}

}
