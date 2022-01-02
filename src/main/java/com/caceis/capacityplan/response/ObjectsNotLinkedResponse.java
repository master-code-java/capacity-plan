package com.caceis.capacityplan.response;

import com.caceis.capacityplan.entity.Sprint;

import java.util.List;

public class ObjectsNotLinkedResponse {

    private int amount;
    private List<String> uuids;

    public ObjectsNotLinkedResponse(List<String> uuids) {
        this.amount=uuids.size();
        this.uuids = uuids;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<String> getUuids() {
        return uuids;
    }

    public void setUuids(List<String> uuids) {
        this.uuids = uuids;
    }
}
