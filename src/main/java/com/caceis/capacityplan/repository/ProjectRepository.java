package com.caceis.capacityplan.repository;

import com.caceis.capacityplan.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	//@Query(value="select new com.caceis.capacity.dto.ProjectsDto(p.id,p.name,t.uuid,t.title) FROM Task t INNER JOIN t.project p")
	//List<ProjectsDto> getProjectsAndTasks();

    Project findByName(String name);

}
