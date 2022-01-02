package com.caceis.capacityplan.service.impl;

import com.caceis.capacityplan.entity.SprintAndTask;
import com.caceis.capacityplan.entity.Task;
import com.caceis.capacityplan.exception.ServiceException;
import com.caceis.capacityplan.repository.SprintAndTaskRepository;
import com.caceis.capacityplan.repository.TaskRepository;
import com.caceis.capacityplan.request.TaskRequest;
import com.caceis.capacityplan.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger LOG = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    SprintAndTaskRepository sprintAndTaskRepository;

    private static final Logger log = LoggerFactory.getLogger(TaskService.class);


    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task get(String uuid) throws Exception {
        log.info("Buscando task com o id:{}", uuid);

        Task task = this.taskRepository.findByUuid(uuid)
                .orElseThrow(() -> new ServiceException("Record not found for UUID: " + uuid));

        log.info("encontrado a task: {}", task);

        return task;

    }

    @Override
    public Task save(TaskRequest taskRequest) {
        LOG.info("Add taskRequest [{}]", taskRequest);

        return this.taskRepository.save(getTask(taskRequest));
    }

    @Override
    public List<Task> saveAll(List<TaskRequest> tasksRequest) {
        return this.taskRepository.saveAll(getTasks(tasksRequest));
    }

    @Override
    public List<Task> getAll(String sprintUuid) {

        List<Task> tasks = new ArrayList<>();

        sprintAndTaskRepository.findBySprintUuid(sprintUuid)
                .stream()
                .map(SprintAndTask::getTaskUuid)
                .map(taskRepository::findByUuid)
                .forEach(task -> task.ifPresent(tasks::add));

        return tasks;

    }

    @Override
    public List<String> getAllWithoutSprint() {
       return this.taskRepository.getAllWithoutSprint();
    }

    @Override
    public List<Task> getAll() {
        return this.taskRepository.findAll();
    }

    private Task getTask(TaskRequest taskRequest) {
        Task task = new Task();
        task.setUuid(UUID.randomUUID().toString());
        task.setEstimation(taskRequest.getEstimation());
        task.setIdentifier(taskRequest.getIdentifier());
        task.setSummary(taskRequest.getSummary());
        task.setProjectUuid(taskRequest.getProjectUuid());
        task.setAssigneeUuid(taskRequest.getAssigneUuid());
        return task;
    }

    private List<Task> getTasks(List<TaskRequest> tasksRequests) {
        return tasksRequests.stream()
                .map(this::getTask)
                .collect(Collectors.toList());
    }

}
