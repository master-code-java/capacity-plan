package com.caceis.capacityplan.repository;

import com.caceis.capacityplan.entity.Project;
import com.caceis.capacityplan.entity.SprintAndTask;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface DashboardRepository extends CrudRepository<SprintAndTask, Long> {

    @Query(value = "select \n" +
            "        prj.name \t\t\t\t\t\tas project_name,\n" +
            "        sum(t.estimation)\t\t\t\tas amount_of_hours\n" +
            "from \n" +
            "\tcapacity.sprint_and_task st \n" +
            "inner join task t\n" +
            "on t.uuid=st.task_uuid\n" +
            "inner join project prj\n" +
            "on t.project_uuid=prj.uuid  \n" +
            "where \n" +
            "\tst.sprint_uuid=\"d61c6060-951a-4f81-afc1-e1503bb7a811\"\n" +
            "group by prj.name",nativeQuery = true)
    List<Map<String, Long>> getCapacityPerProject(@Param("sprintUuid") String sprintUuid);

}
