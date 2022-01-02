package com.caceis.capacityplan.controller;

import com.caceis.capacityplan.response.CapacityInHoursResponse;
import com.caceis.capacityplan.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DashboardController {

    private static final String CONTEXT ="dashboard";

    @Autowired
    DashboardService dashboardService;

    @GetMapping(CONTEXT+"/capacityInHours")
    public CapacityInHoursResponse capacityInHours(@RequestParam(value = "sprintUuid", required = false) String sprintUuid) {
        return dashboardService.getCapacityInHours(sprintUuid);
    }

    @GetMapping(CONTEXT+"/capacityPerProject")
    public List<Map<String, Long>> capacityPerProject(@RequestParam(value = "sprintUuid", required = false) String sprintUuid) {
        return dashboardService.capacityPerProject(sprintUuid);
    }

}
