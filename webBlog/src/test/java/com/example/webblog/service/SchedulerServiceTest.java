package com.example.webblog.service;

import static com.example.webblog.repository.Team.DEFAULT_NAME;
import static com.example.webblog.service.MemberService.SEOUL_ZONE_OFFSET;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.webblog.repository.Member;
import com.example.webblog.repository.MemberRepository;
import com.example.webblog.repository.Team;
import com.example.webblog.repository.TeamRepository;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.xml.bind.annotation.XmlType.DEFAULT;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Slf4j
class SchedulerServiceTest {

  private static final String TEST_TEAM_NAME = "정현모 팀";

  @Autowired
  private SchedulerService schedulerService;

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private TeamRepository teamRepository;

  @Test
  @DisplayName("스케줄 작업 테스트")
  public void testScheduledTask() throws Exception {
    // given
    generateTeam(DEFAULT_NAME);
    Team myTeam = generateTeam(TEST_TEAM_NAME);
    generateMember();
    generateMember();
    generateMember();
    Date taskDate = getDatePlusSeconds(1);
    Runnable task = changeEveryMemberTeamTo(myTeam);

    // before tasking
    List<Member> beforeAllMembers = memberRepository.findAll();
    List<Team> beforeAllMemberTeams = beforeAllMembers.stream().map(Member::getTeam).toList();
    assertThat(beforeAllMemberTeams).hasSize(3);
    assertThat(beforeAllMemberTeams.get(0)).isNotNull();
    assertThat(beforeAllMemberTeams.get(1)).isNotNull();
    assertThat(beforeAllMemberTeams.get(2)).isNotNull();
    assertThat(beforeAllMemberTeams.get(0).getName()).isEqualTo(DEFAULT_NAME);
    assertThat(beforeAllMemberTeams.get(1).getName()).isEqualTo(DEFAULT_NAME);
    assertThat(beforeAllMemberTeams.get(2).getName()).isEqualTo(DEFAULT_NAME);

    // when
    schedulerService.scheduleTask(task, taskDate);

    Thread.sleep(3000); // scheduler task가 완료되길 기다리기

    // after tasking
    List<Member> afterAllMembers = memberRepository.findAll();
    List<Team> afterAllMemberTeams = afterAllMembers.stream().map(Member::getTeam).toList();
    assertThat(afterAllMemberTeams).hasSize(3);
    assertThat(afterAllMemberTeams.get(0)).isNotNull();
    assertThat(afterAllMemberTeams.get(1)).isNotNull();
    assertThat(afterAllMemberTeams.get(2)).isNotNull();
    assertThat(afterAllMemberTeams.get(0).getName()).isEqualTo(TEST_TEAM_NAME);
    assertThat(afterAllMemberTeams.get(1).getName()).isEqualTo(TEST_TEAM_NAME);
    assertThat(afterAllMemberTeams.get(2).getName()).isEqualTo(TEST_TEAM_NAME);
  }

  private Team generateTeam(String teamName) {
    return teamRepository.save(Team.builder()
        .name(teamName)
        .build());
  }

  private Date getDatePlusSeconds(int seconds) {
    return Date.from(now().plusSeconds(seconds).toInstant(SEOUL_ZONE_OFFSET));
  }

  @Transactional
  public Runnable changeEveryMemberTeamTo(Team team) {
    return () -> {
      List<Member> members = memberRepository.findAll();
      for (Member member : members) {
        member.changeTeam(team);
      }
      memberRepository.saveAll(members);
      log.info(memberRepository.findAll().toString());
    };
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