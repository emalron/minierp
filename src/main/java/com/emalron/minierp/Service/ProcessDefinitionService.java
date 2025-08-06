package com.emalron.minierp.Service;

import java.util.Optional;

import com.emalron.minierp.Entity.ProcessDefinition;

public interface ProcessDefinitionService {
  ProcessDefinition savDefinition(ProcessDefinition definition);
  Optional<ProcessDefinition> getDefinition(Long id);
  void deleteDefinition(Long id);
}
