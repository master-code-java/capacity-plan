package com.caceis.capacityplan.service.impl;

import com.caceis.capacityplan.entity.Project;
import com.caceis.capacityplan.repository.ProjectRepository;
import com.caceis.capacityplan.service.ProjectService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

	public static final String NAME = "name";

	@Autowired
	private ProjectRepository projectRepository;
	
	
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}


	@Override
	public Project add(ObjectNode request) {

		Project project = new Project();
		project.setUuid(UUID.randomUUID().toString());
		project.setName(request.get(NAME).asText());

		return projectRepository.save(project);
	}

	@Override
	public List<Project> getAll() {
		return projectRepository.findAll();
	}

	@Override
	public Project get(int id) throws Exception {
		return null;
	}

	@Override
	public Project get(String name) {
		return projectRepository.findByName(name);
	}
}
