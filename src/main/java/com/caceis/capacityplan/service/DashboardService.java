package com.caceis.capacityplan.service;

import com.caceis.capacityplan.response.CapacityInHoursResponse;
import com.caceis.capacityplan.response.CapacityPerProjectResponse;

import java.util.List;

public interface DashboardService {

    CapacityInHoursResponse getCapacityInHours(String sprintUuid);

    List<CapacityPerProjectResponse> capacityPerProject(String sprintUuid);
}
