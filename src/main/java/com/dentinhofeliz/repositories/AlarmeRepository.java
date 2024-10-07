package com.dentinhofeliz.repositories;

import com.dentinhofeliz.entities.Alarme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmeRepository extends JpaRepository<Alarme, Long> {
}
