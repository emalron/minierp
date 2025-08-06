package com.emalron.minierp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emalron.minierp.Entity.ProcessTransition;

public interface ProcessTransitionRepository extends JpaRepository<ProcessTransition, Long> {
  
}
