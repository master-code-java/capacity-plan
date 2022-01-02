package com.caceis.capacityplan.service;

import com.caceis.capacityplan.entity.Task;
import com.caceis.capacityplan.request.TaskRequest;

import java.util.List;

public interface TaskService {

	Task get(String uuid) throws Exception;
	List<Task> getAll();
	List<Task> getAll(String sprintUuid);
	List<String> getAllWithoutSprint();

	Task save(TaskRequest task);
	List<Task> saveAll(List<TaskRequest> tasksRequest);
}
