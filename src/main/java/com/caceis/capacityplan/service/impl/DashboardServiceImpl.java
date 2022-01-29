package com.caceis.capacityplan.service.impl;

import com.caceis.capacityplan.entity.Task;
import com.caceis.capacityplan.repository.DashboardRepository;
import com.caceis.capacityplan.response.CapacityInHoursResponse;
import com.caceis.capacityplan.response.CapacityPerProjectResponse;
import com.caceis.capacityplan.service.DashboardService;
import com.caceis.capacityplan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private DashboardRepository dashboardRepository;

    private final String PROJECT_NAME = "project_name";
    private final String AMOUNT_OF_HOURS = "amount_of_hours";

    @Override
    public CapacityInHoursResponse getCapacityInHours(String sprintUuid) {

        Long hoursRequested = taskService.getAll(sprintUuid).stream()
                .map(Task::getEstimation)
                .reduce(0L, Long::sum);

        long hoursProvided = 1000L;
        long hoursRemaining = hoursProvided - hoursRequested;

        return new CapacityInHoursResponse(hoursRequested, hoursProvided, hoursRemaining);
    }

    @Override
    public List<CapacityPerProjectResponse> capacityPerProject(String sprintUuid) {

        return dashboardRepository.getCapacityPerProject(sprintUuid).stream()
                .map(response -> new CapacityPerProjectResponse(
                        response.get(PROJECT_NAME).toString(),
                        Double.valueOf(response.get(AMOUNT_OF_HOURS).toString())))
                .collect(Collectors.toList());

    }
}
