package com.caceis.capacityplan.service.impl;

import com.caceis.capacityplan.constants.Constants;
import com.caceis.capacityplan.entity.Assigne;
import com.caceis.capacityplan.entity.Project;
import com.caceis.capacityplan.request.TaskRequest;
import com.caceis.capacityplan.service.AssigneeService;
import com.caceis.capacityplan.service.FileService;
import com.caceis.capacityplan.service.ProjectService;
import com.caceis.capacityplan.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOG = LoggerFactory.getLogger(FileService.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private AssigneeService assigneeService;

    @Autowired
    private ProjectService projectService;


    @Override
    public boolean processFile(MultipartFile file) {
        try (Scanner scanner = new Scanner(file.getInputStream(), Charset.defaultCharset())) {
            saveRecords(createRecords(getProjects(), getAssignees(), file, scanner, getSplitter(scanner)));

        } catch (IOException e) {
            e.printStackTrace();

        }

        return true;

    }

    private String getSplitter(Scanner sc) {
        return sc.nextLine().contains(Constants.COMMA) ? Constants.COMMA : Constants.SEMICOLON;
    }

    private boolean saveRecords(List<TaskRequest> records) {
        taskService.saveAll(records);

        return true;
    }

    private List<Assigne> getAssignees() {
        return assigneeService.getAll();
    }

    private List<TaskRequest> createRecords(List<Project> projects, List<Assigne> assignees, MultipartFile file, Scanner sc, String splitter) {
        int amountOfLines = 0;
        List<TaskRequest> records = new ArrayList<>();

        LOG.info("Processando arquivo: [{}]", file.getOriginalFilename());

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] column = line.split(splitter);

            records.add(new TaskRequest(
                    getIdentifier(column),
                    getSummary(column),
                    getEstimation(column[4]),
                    getAssigneeUuid(column[2], assignees),
                    getProjectUuid(column[3], projects)));

            amountOfLines++;
        }

        LOG.info("All records created successfully, total: [{}]", amountOfLines);


        return records;

    }

    private List<Project> getProjects() {
        return projectService.getAll();
    }

    private long getEstimation(String s) {
        return Long.parseLong(s);
    }

    private String getSummary(String[] column) {
        return column[1];
    }

    private String getIdentifier(String[] column) {
        return column[0];
    }

    private String getAssigneeUuid(String name, List<Assigne> assignees) {
        return assignees.stream()
                .filter(assignee -> assignee.getName().equals(name))
                .map(Assigne::getUuid)
                .findFirst()
                .orElse(Constants.EMPTY_STRING);
    }

    private String getProjectUuid(String name, List<Project> projects) {
        return projects.stream()
                .filter(project -> project.getName().equals(name))
                .map(Project::getUuid)
                .findFirst()
                .orElse(Constants.EMPTY_STRING);
    }
}
