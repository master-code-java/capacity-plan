package com.caceis.capacityplan.repository;

import com.caceis.capacityplan.entity.SprintAndTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintAndTaskRepository extends JpaRepository<SprintAndTask, Long> {

    List<SprintAndTask> findBySprintUuid(String sprintUuid);

}
