package com.caceis.capacityplan.service.impl;

import com.caceis.capacityplan.entity.Task;
import com.caceis.capacityplan.repository.DashboardRepository;
import com.caceis.capacityplan.response.CapacityInHoursResponse;
import com.caceis.capacityplan.service.DashboardService;
import com.caceis.capacityplan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private DashboardRepository dashboardRepository;

    @Override
    public CapacityInHoursResponse getCapacityInHours(String sprintUuid) {

        Long hoursRequested = taskService.getAll(sprintUuid).stream()
                .map(Task::getEstimation)
                .reduce(0L, Long::sum);

        long hoursProvided = 1000L;

        return new CapacityInHoursResponse(hoursRequested,hoursProvided);
    }

    @Override
    public List<Map<String, Long>> capacityPerProject(String sprintUuid) {

        return dashboardRepository.getCapacityPerProject(sprintUuid);

    }
}
