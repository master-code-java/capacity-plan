package com.caceis.capacityplan.controller;

import com.caceis.capacityplan.entity.Project;
import com.caceis.capacityplan.service.ProjectService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ProjectController {

	private final String CONTEXT = "projects";


	@Autowired
	ProjectService projectService;

	@PostMapping(CONTEXT)
	public ResponseEntity<Project> add(@RequestBody ObjectNode request) {

		return ResponseEntity.status(HttpStatus.CREATED).body(this.projectService.add(request));

	}

	@GetMapping(CONTEXT + "/{id}")
	public Project get(@PathVariable int id) {

		return null;
	}
}
