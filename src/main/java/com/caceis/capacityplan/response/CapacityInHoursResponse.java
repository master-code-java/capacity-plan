package com.caceis.capacityplan.response;

public class CapacityInHoursResponse {

    private Long hoursRequested;
    private Long hoursAvailable;

    public CapacityInHoursResponse(Long hoursRequested, Long hoursAvailable) {
        this.hoursRequested = hoursRequested;
        this.hoursAvailable = hoursAvailable;
    }

    public Long getHoursRequested() {
        return hoursRequested;
    }

    public void setHoursRequested(Long hoursRequested) {
        this.hoursRequested = hoursRequested;
    }

    public Long getHoursAvailable() {
        return hoursAvailable;
    }

    public void setHoursAvailable(Long hoursAvailable) {
        this.hoursAvailable = hoursAvailable;
    }
}
