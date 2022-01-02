package com.caceis.capacityplan.repository;

import com.caceis.capacityplan.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByUuid(String uuid);

    @Query(value = "SELECT\n" +
            "t.uuid     as task_uuid\n" +
            "FROM task t\n" +
            "WHERE NOT t.uuid \n" +
            "IN(SELECT \n" +
            "   st.task_uuid    AS task_uuid\n" +
            "   FROM sprint_and_task st\n" +
            "   INNER JOIN sprint s\n" +
            "   ON s.uuid=st.sprint_uuid\n" +
            "   WHERE s.is_active=1)", nativeQuery = true)
    List<String> getAllWithoutSprint();
}
