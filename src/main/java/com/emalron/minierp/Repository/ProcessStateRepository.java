package com.emalron.minierp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emalron.minierp.Entity.ProcessState;

public interface ProcessStateRepository extends JpaRepository<ProcessState, Long> {
  
}
