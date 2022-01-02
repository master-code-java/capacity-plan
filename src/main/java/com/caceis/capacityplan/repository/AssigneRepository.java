package com.caceis.capacityplan.repository;

import com.caceis.capacityplan.entity.Assigne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssigneRepository extends JpaRepository<Assigne, Long> {

    Assigne findByName(String name);

}
