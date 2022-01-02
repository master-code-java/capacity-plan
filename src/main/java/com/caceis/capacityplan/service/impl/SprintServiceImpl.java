package com.caceis.capacityplan.service.impl;

import com.caceis.capacityplan.entity.Sprint;
import com.caceis.capacityplan.entity.SprintAndTask;
import com.caceis.capacityplan.exception.ServiceException;
import com.caceis.capacityplan.repository.SprintAndTaskRepository;
import com.caceis.capacityplan.repository.SprintRepository;
import com.caceis.capacityplan.request.LinkSprintWithTaskRequest;
import com.caceis.capacityplan.request.SprintRequest;
import com.caceis.capacityplan.response.ObjectsNotLinkedResponse;
import com.caceis.capacityplan.service.FileService;
import com.caceis.capacityplan.service.SprintService;
import com.caceis.capacityplan.utils.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SprintServiceImpl implements SprintService {


    private static final Logger LOG = LoggerFactory.getLogger(SprintService.class);

    @Autowired
    SprintRepository sprintRepository;

    @Autowired
    SprintAndTaskRepository sprintAndTaskRepository;

    @Override
    public Sprint get(String uuid) throws ServiceException {
        return sprintRepository.findByUuid(uuid)
                .orElseThrow(() -> new ServiceException("Record not found for UUID: " + uuid));
    }

    @Override
    public Sprint add(SprintRequest request) {

        return sprintRepository.save(new Sprint(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getStartDate(),
                request.getEndDate()));
    }

    @Override
    public boolean linkSprintWithTask(LinkSprintWithTaskRequest request) {

        request.getTasksUuids()
                .forEach(taskUuid -> sprintAndTaskRepository.save(
                        new SprintAndTask(request.getSprintUuid(), taskUuid)));

        return true;
    }


    @Override
    public boolean setActive(Boolean isActive, String uuid) {
        return BooleanUtils.toBoolean(sprintRepository.setActive(isActive, uuid));
    }

    @Override
    public List<Sprint> getAll() {
        return sprintRepository.findAll();
    }

    @Override
    public ObjectsNotLinkedResponse getAllWithoutTask() {
        return new ObjectsNotLinkedResponse(sprintRepository.getAllWithoutTask());
    }


}
