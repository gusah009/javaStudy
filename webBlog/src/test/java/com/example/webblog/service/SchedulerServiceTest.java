package com.example.webblog.service;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class SchedulerServiceTest {

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
    Member member1 = generateMember();
    Member member2 = generateMember();
    Member member3 = generateMember();
    Member member4 = generateMember();
    Date taskDate = getDatePlusSeconds(1);
    Team myTeam = generateTeam("정현모");
    Runnable task = changeEveryMemberTeamTo(myTeam);

    // before tasking
    List<Member> all = memberRepository.findAll();
    assertThat(all).hasSize(4);
    assertThat(all).contains(member1);
    assertThat(all).contains(member2);
    assertThat(all).contains(member3);
    assertThat(all).contains(member4);

    // when
    schedulerService.scheduleTask(task, taskDate);

    Thread.sleep(3000); // scheduler task가 완료되길 기다리기

    // after tasking
    List<String> allMemberNames = all.stream().map(Member::getName).toList();
    assertThat(all).hasSize(4);
    assertThat(allMemberNames).contains(member1.getName());
    assertThat(allMemberNames).contains(member2.getName());
    assertThat(allMemberNames).contains(member3.getName());
    assertThat(allMemberNames).contains(member4.getName());
  }

  private Team generateTeam(String teamName) {
    return teamRepository.save(Team.builder()
        .name(teamName)
        .build());
  }

  private Date getDatePlusSeconds(int seconds) {
    return Date.from(now().plusSeconds(seconds).toInstant(SEOUL_ZONE_OFFSET));
  }

  private Runnable changeEveryMemberTeamTo(Team team) {
    return () -> {
      List<Member> allJeongMembers = memberRepository.findAll();
      for (Member member : allJeongMembers) {
        member.changeTeam(team);
      }
      memberRepository.saveAll(allJeongMembers);
    };
  }

  private Member generateMember() {
    String uniqueVal = UUID.randomUUID().toString().substring(0, 5);
    int age = new Random().nextInt(50);
    return memberRepository.save(Member.builder()
        .name("name_" + uniqueVal)
        .age(age)
        .build());
  }
}