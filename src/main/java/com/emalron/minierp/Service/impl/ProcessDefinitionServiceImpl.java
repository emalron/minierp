package com.emalron.minierp.Service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emalron.minierp.Entity.ProcessDefinition;
import com.emalron.minierp.Entity.ProcessState;
import com.emalron.minierp.Entity.ProcessTransition;
import com.emalron.minierp.Repository.ProcessDefinitionRepository;
import com.emalron.minierp.Repository.ProcessStateRepository;
import com.emalron.minierp.Repository.ProcessTransitionRepository;
import com.emalron.minierp.Service.ProcessDefinitionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {

  private final ProcessDefinitionRepository definitionRepo;
  private final ProcessStateRepository stateRepo;
  private final ProcessTransitionRepository transitionRepo;

  @Override
  @Transactional
  public ProcessDefinition savDefinition(ProcessDefinition definition) {
    for(ProcessState state : definition.getStates()) {
      state.setProcessDefinition(definition);
    }
    for(ProcessTransition transition : definition.getTransitions()) {
      transition.setProcessDefinition(definition);
    }
    return definitionRepo.save(definition);
  }

  @Override
  public Optional<ProcessDefinition> getDefinition(Long id) {
    return definitionRepo.findById(id);
  }

  @Override
  public void deleteDefinition(Long id) {
    definitionRepo.deleteById(id);
  }
  
}
