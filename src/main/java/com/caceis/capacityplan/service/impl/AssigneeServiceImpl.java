package com.caceis.capacityplan.service.impl;

import com.caceis.capacityplan.entity.Assigne;
import com.caceis.capacityplan.repository.AssigneRepository;
import com.caceis.capacityplan.service.AssigneeService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AssigneeServiceImpl implements AssigneeService {

    public static final String NAME = "name";

    @Autowired
    private AssigneRepository assigneRepository;

    @Override
    public Assigne add(ObjectNode request) {

        Assigne assigne = new Assigne();
        assigne.setUuid(UUID.randomUUID().toString());
        assigne.setName(request.get(NAME).asText());

        return assigneRepository.save(assigne);
    }

    @Override
    public Assigne get(String name) {
        return assigneRepository.findByName(name);
    }

    @Override
    public List<Assigne> getAll() {
        return assigneRepository.findAll();
    }
}
