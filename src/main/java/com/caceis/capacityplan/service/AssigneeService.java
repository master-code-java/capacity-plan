package com.caceis.capacityplan.service;

import com.caceis.capacityplan.entity.Assigne;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface AssigneeService {

    Assigne add(ObjectNode request);
    Assigne get(String name);
    List<Assigne> getAll();
}
