package com.caceis.capacityplan.service;

import com.caceis.capacityplan.entity.Sprint;
import com.caceis.capacityplan.exception.ServiceException;
import com.caceis.capacityplan.request.LinkSprintWithTaskRequest;
import com.caceis.capacityplan.request.SprintRequest;
import com.caceis.capacityplan.response.ObjectsNotLinkedResponse;

import java.util.List;

public interface SprintService {

    Sprint get(String uuid) throws ServiceException;

    List<Sprint> getAll();

    ObjectsNotLinkedResponse getAllWithoutTask();

    Sprint add(SprintRequest request);

    boolean linkSprintWithTask(LinkSprintWithTaskRequest request);

    boolean setActive(Boolean isActive, String uuid);
}
