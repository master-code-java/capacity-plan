package com.caceis.capacityplan.repository;

import com.caceis.capacityplan.entity.Project;
import com.caceis.capacityplan.entity.SprintAndTask;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface DashboardRepository extends CrudRepository<SprintAndTask, Long> {

    @Query(value = "SELECT \n" +
            "        prj.name as project_name,\n" +
            "        SUM(t.estimation) as amount_of_hours\n" +
            "FROM \n" +
            "capacity.sprint_and_task st \n" +
            "INNER JOIN task t\n" +
            "on t.uuid=st.task_uuid\n" +
            "INNER JOIN project prj\n" +
            "on t.project_uuid=prj.uuid  \n" +
            "WHERE \n" +
            "st.sprint_uuid=:sprintUuid\n" +
            "GROUP BY prj.name",nativeQuery = true)
    List<Map<String, Object>> getCapacityPerProject(@Param("sprintUuid") String sprintUuid);

}
