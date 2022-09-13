package com.example.webblog.service;

import static com.example.webblog.repository.Team.DEFAULT_NAME;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.webblog.repository.Member;
import com.example.webblog.repository.MemberRepository;
import com.example.webblog.repository.Team;
import com.example.webblog.repository.TeamRepository;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootTest
@Transactional
class MemberServiceTest {

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  MemberRepository memberRepository;

  @Autowired
  MemberService memberService;

  @Autowired
  EntityManager em;

  @TestConfiguration
  @RequiredArgsConstructor
  static class TestSchedulerConfig {

    private final PlatformTransactionManager txManager;

    @Bean
    TransactionTemplate schedulerTransactionTemplateTest() {
      TransactionTemplate txTemplate = new TransactionTemplate(txManager);
      txTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
      txTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_MANDATORY);
      return txTemplate;
    }
  }

  @Test
  public void reserveMemberTeamChange() throws InterruptedException {
    // given
    generateTeam(DEFAULT_NAME);
    Team changeTeam = generateTeam("정현모");
    generateMember();
    generateMember();

    // 쿼리가 나가야 새로운 스레드의 트랜잭션에서 데이터를 읽을 수 있다.
    em.flush();
    em.clear();

    // when
    String result = memberService.reserveMemberTeamChange(1);

    // wait task running
    Thread.sleep(5000);

    // then
    assertThat(result).isEqualTo("SUCCESS");
    List<Member> resultMembers = memberRepository.findAll();
    System.out.println("resultMembers = " + resultMembers);
    Thread.sleep(2000);
//    assertThat(resultMembers.get(0).getTeam()).isEqualTo(changeTeam);
//    assertThat(resultMembers.get(1).getTeam()).isEqualTo(changeTeam);
  }

  private Team generateTeam(String teamName) {
    return teamRepository.save(Team.builder()
        .name(teamName)
        .build());
  }

  private Member generateMember() {
    String uniqueVal = UUID.randomUUID().toString().substring(0, 5);
    int age = new Random().nextInt(50);
    Team noTeam = teamRepository.findByName(DEFAULT_NAME).orElseThrow();
    return memberRepository.save(Member.builder()
        .name("name_" + uniqueVal)
        .age(age)
        .team(noTeam)
        .build());
  }
}