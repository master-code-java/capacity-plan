package com.caceis.capacityplan.request;

import java.util.List;

public class LinkSprintWithTaskRequest {

    private String sprintUuid;
    private List<String> tasksUuids;

    public String getSprintUuid() {
        return sprintUuid;
    }

    public void setSprintUuid(String sprintUuid) {
        this.sprintUuid = sprintUuid;
    }

    public List<String> getTasksUuids() {
        return tasksUuids;
    }

    public void setTasksUuids(List<String> tasksUuids) {
        this.tasksUuids = tasksUuids;
    }
}
