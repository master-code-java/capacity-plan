package com.caceis.capacityplan.service;

import com.caceis.capacityplan.response.CapacityInHoursResponse;

import java.util.List;
import java.util.Map;

public interface DashboardService {

    CapacityInHoursResponse getCapacityInHours(String sprintUuid);

    List<Map<String, Long>> capacityPerProject(String sprintUuid);
}
