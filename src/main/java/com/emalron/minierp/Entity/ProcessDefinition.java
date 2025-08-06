package com.emalron.minierp.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "process_definition")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProcessDefinition {
  @Id @GeneratedValue
  private Long id;
  
  private String name;
  private String description;

  @Column(name = "created_at")
  private LocalDateTime createdAt = LocalDateTime.now();
  
  @OneToMany(mappedBy = "processDefinition", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ProcessState> states = new ArrayList<>();

  @OneToMany(mappedBy = "processDefinition", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ProcessTransition> transitions = new ArrayList<>();
}
