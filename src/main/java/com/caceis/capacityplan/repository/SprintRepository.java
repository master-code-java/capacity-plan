package com.caceis.capacityplan.repository;

import com.caceis.capacityplan.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface SprintRepository extends JpaRepository<Sprint, Long> {

    Optional<Sprint> findByUuid(String uuid);

    @Query(value = "SELECT \n" +
            "uuid   as uuid\n" +
            "FROM sprint s\n" +
            "WHERE\n" +
            "   s.is_active=TRUE\n" +
            "   AND NOT s.uuid IN(\n" +
            "       SELECT sprint_uuid \n" +
            "       FROM sprint_and_task);",nativeQuery = true)
    List<String> getAllWithoutTask();

    @Transactional
    @Modifying
    @Query(value="UPDATE sprint s SET s.is_active=:isActive WHERE s.uuid=:uuid", nativeQuery = true)
    int setActive(@Param("isActive") Boolean isActive, @Param("uuid") String uuid);

}
