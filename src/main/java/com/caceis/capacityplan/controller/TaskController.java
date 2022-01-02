package com.caceis.capacityplan.controller;

import com.caceis.capacityplan.entity.Task;
import com.caceis.capacityplan.request.TaskRequest;
import com.caceis.capacityplan.response.ObjectsNotLinkedResponse;
import com.caceis.capacityplan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    private final static String CONTEXT = "task";


    @PostMapping(CONTEXT)
    public ResponseEntity<Task> add(@RequestBody TaskRequest taskRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.taskService.save(taskRequest));

    }

    @GetMapping(CONTEXT + "/{uuid}")
    public Task get(@PathVariable String uuid) {

        try {
            return this.taskService.get(uuid);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());

        }
    }

    @GetMapping(CONTEXT)
    public List<Task> getAllFromSprint(@RequestParam(value = "sprintUuid", required = false) String sprintUuid) {
        if (sprintUuid.isEmpty()) {
            return this.taskService.getAll();
        } else {
            return this.taskService.getAll(sprintUuid);
        }

    }


    @GetMapping(CONTEXT+"/getAllWithoutSprint")
    public ObjectsNotLinkedResponse getAllWithoutSprint() {

        List<String> allWithoutSprint = taskService.getAllWithoutSprint();
        return new ObjectsNotLinkedResponse(allWithoutSprint);

    }
}
