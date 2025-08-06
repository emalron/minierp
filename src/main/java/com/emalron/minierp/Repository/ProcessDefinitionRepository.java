package com.emalron.minierp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emalron.minierp.Entity.ProcessDefinition;

public interface ProcessDefinitionRepository extends JpaRepository<ProcessDefinition, Long> {}
