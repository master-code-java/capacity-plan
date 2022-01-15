package com.caceis.capacityplan.response;

public class CapacityPerProjectResponse {

    private String projectName;
    private Double amountOfHours;

    public CapacityPerProjectResponse(String projectName, Double amountOfHours) {
        this.projectName = projectName;
        this.amountOfHours = amountOfHours;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getAmountOfHours() {
        return amountOfHours;
    }

    public void setAmountOfHours(Double amountOfHours) {
        this.amountOfHours = amountOfHours;
    }
}
