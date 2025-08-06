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
@Table(name = "process_state")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProcessState {
  @Id @GeneratedValue
  private Long id;

  private String name;

  @Column(name = "is_start")
  private boolean isStart;

  @Column(name = "is_end")
  private boolean isEnd;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "process_defintion_id")
  private ProcessDefinition processDefinition;
}
