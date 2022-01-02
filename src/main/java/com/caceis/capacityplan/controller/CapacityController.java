package com.caceis.capacityplan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CapacityController {

	@GetMapping("/")
	public String helloWorld() {
		return "Capacity plan 1.0";
	}
	
}
