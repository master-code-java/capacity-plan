package com.caceis.capacityplan.controller;

import com.caceis.capacityplan.entity.Sprint;
import com.caceis.capacityplan.exception.ServiceException;
import com.caceis.capacityplan.request.LinkSprintWithTaskRequest;
import com.caceis.capacityplan.request.SprintRequest;
import com.caceis.capacityplan.response.ObjectsNotLinkedResponse;
import com.caceis.capacityplan.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SprintController {

    private static final String CONTEXT ="sprint";

    @Autowired
    SprintService sprintService;

    @PostMapping(CONTEXT)
    public Sprint add(@RequestBody SprintRequest request){
        return sprintService.add(request);
    }

    @PostMapping(CONTEXT+"/createLink")
    public boolean linkTasks(@RequestBody LinkSprintWithTaskRequest request){
            return sprintService.linkSprintWithTask(request);
    }

    @GetMapping(CONTEXT+"/{uuid}")
    public Sprint get(@PathVariable String uuid) throws ServiceException {
        return sprintService.get(uuid);
    }

    @GetMapping(CONTEXT)
    public List<Sprint> getAll() throws ServiceException {
        return sprintService.getAll();
    }

    @GetMapping(CONTEXT+"/getAllWithoutTask")
    public ObjectsNotLinkedResponse getAllWithoutTask() throws ServiceException {
        return sprintService.getAllWithoutTask();
    }

    @DeleteMapping(CONTEXT+"/{uuid}")
    public boolean delete(@PathVariable String uuid) throws ServiceException {
        return sprintService.setActive(false, uuid);
    }

    @PatchMapping(CONTEXT+"/deactivate/{uuid}")
    public boolean deactivate(@PathVariable String uuid) throws ServiceException {
        return sprintService.setActive(false, uuid);
    }

    @PatchMapping(CONTEXT+"/activate/{uuid}")
    public boolean activate(@PathVariable String uuid) throws ServiceException {
        return sprintService.setActive(true, uuid);
    }
}