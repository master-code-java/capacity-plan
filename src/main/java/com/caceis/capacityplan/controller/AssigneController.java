package com.caceis.capacityplan.controller;

import com.caceis.capacityplan.entity.Assigne;
import com.caceis.capacityplan.service.AssigneeService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AssigneController {

    @Autowired
    private AssigneeService assigneeService;

    private final static String CONTEXT ="assignes";

    @PostMapping(CONTEXT)
    public Assigne createAssigne(@RequestBody ObjectNode request){

        return assigneeService.add(request);
    }

}
