package com.caceis.capacityplan.service;

import com.caceis.capacityplan.entity.Project;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface ProjectService {
	
	Project add(ObjectNode request);
	List<Project> getAll();
	Project get(int id) throws Exception;
	Project get(String name);

}
