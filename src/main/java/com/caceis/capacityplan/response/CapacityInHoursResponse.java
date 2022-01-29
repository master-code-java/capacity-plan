package com.caceis.capacityplan.response;

public class CapacityInHoursResponse {

    private Long hoursRequested;
    private Long hoursAvailable;
    private Long hoursRemaining;

    public CapacityInHoursResponse(Long hoursRequested, Long hoursAvailable, Long hoursRemaining) {
        this.hoursRequested = hoursRequested;
        this.hoursAvailable = hoursAvailable;
        this.hoursRemaining = hoursRemaining;
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

    public Long getHoursRemaining() {
        return hoursRemaining;
    }

    public void setHoursRemaining(Long hoursRemaining) {
        this.hoursRemaining = hoursRemaining;
    }
}
