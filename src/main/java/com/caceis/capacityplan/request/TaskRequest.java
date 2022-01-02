package com.caceis.capacityplan.request;

public class TaskRequest {

    private String identifier;
    private String summary;
    private Long estimation;
    private String assigneUuid;
    private String projectUuid;


    public TaskRequest(String identifier, String summary, Long estimation, String assigneUuid, String projectUuid) {
        this.identifier = identifier;
        this.summary = summary;
        this.estimation = estimation;
        this.assigneUuid = assigneUuid;
        this.projectUuid = projectUuid;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getEstimation() {
        return estimation;
    }

    public void setEstimation(Long estimation) {
        this.estimation = estimation;
    }

    public String getAssigneUuid() {
        return assigneUuid;
    }

    public void setAssigneUuid(String assigneUuid) {
        this.assigneUuid = assigneUuid;
    }

    public String getProjectUuid() {
        return projectUuid;
    }

    public void setProjectUuid(String projectUuid) {
        this.projectUuid = projectUuid;
    }

    @Override
    public String toString() {
        return "TaskRequest{" +
                "identifier='" + identifier + '\'' +
                ", summary='" + summary + '\'' +
                ", estimation=" + estimation +
                ", assigneUuid='" + assigneUuid + '\'' +
                ", projectUuid='" + projectUuid + '\'' +
                '}';
    }
}
