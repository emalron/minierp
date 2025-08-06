package com.emalron.minierp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "process_transition")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProcessTransition {
  @Id @GeneratedValue
  private Long id;

  private String label;

  @Column(name = "handler_name")
  private String handlerName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "process_definition_id")
  private ProcessDefinition processDefinition;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "from_state_id")
  private ProcessState fromState;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "to_state_id")
  private ProcessState toState;  
}
