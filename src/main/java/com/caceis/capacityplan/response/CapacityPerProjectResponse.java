package com.caceis.capacityplan.response;

import java.util.Map;

public class CapacityPerProjectResponse {

    private Map<String,Long> projectsCapacity;

    public CapacityPerProjectResponse(Map<String, Long> projectsCapacity) {
        this.projectsCapacity = projectsCapacity;
    }

    public Map<String, Long> getProjectsCapacity() {
        return projectsCapacity;
    }

    public void setProjectsCapacity(Map<String, Long> projectsCapacity) {
        this.projectsCapacity = projectsCapacity;
    }
}
