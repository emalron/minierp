package com.emalron.minierp.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.emalron.minierp.Entity.ProcessDefinition;
import com.emalron.minierp.Entity.ProcessState;
import com.emalron.minierp.Entity.ProcessTransition;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class ProcessDefinitionServiceTest {
  @Autowired
  private ProcessDefinitionService definitionService;

  @Test
  public void Save_AND_Load_TEST() {
    // given
    ProcessDefinition def = ProcessDefinition.builder()
    .name("결재 프로세스")
    .description("작성 → 결재대기 → 승인 or 반려 → 재요청 가능").build();

    ProcessState draft = ProcessState.builder()
    .name("작성중")
    .isStart(true)
    .isEnd(false).build();

    ProcessState pending = ProcessState.builder()
    .name("결재 대기")
    .isStart(true)
    .isEnd(false).build();

    ProcessState approved = ProcessState.builder()
    .name("승인됨")
    .isStart(false)
    .isEnd(true).build();

    ProcessState rejected = ProcessState.builder()
    .name("반려됨")
    .isStart(false)
    .isEnd(true).build();

    ProcessTransition submit = ProcessTransition.builder()
    .label("제출")
    .handlerName("SubmitHandler")
    .fromState(draft)
    .toState(pending).build();

    ProcessTransition approve = ProcessTransition.builder()
    .label("승인")
    .handlerName("ApproveHandler")
    .fromState(pending)
    .toState(approved).build();

    ProcessTransition reject = ProcessTransition.builder()
    .label("반려")
    .handlerName("RejectHandler")
    .fromState(pending)
    .toState(rejected).build();

    ProcessTransition resubmit = ProcessTransition.builder()
    .label("재제출")
    .handlerName("ResubmitHandler")
    .fromState(rejected)
    .toState(draft).build();

    def.setStates(List.of(draft, pending, approved, rejected));
    def.setTransitions(List.of(submit, approve, reject, resubmit));

    // when
    ProcessDefinition saved = definitionService.savDefinition(def);

    // then
    Optional<ProcessDefinition> loaded = definitionService.getDefinition(saved.getId());

    ProcessDefinition result = loaded.get();

    assertEquals("결재 프로세스", result.getName());
    assertEquals(4, result.getStates().size());
    assertEquals(4, result.getTransitions().size());
  }
}
