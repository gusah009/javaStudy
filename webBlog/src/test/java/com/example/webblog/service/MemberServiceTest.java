package com.example.webblog.service;

import static com.example.webblog.repository.Team.DEFAULT_NAME;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.webblog.repository.Member;
import com.example.webblog.repository.MemberRepository;
import com.example.webblog.repository.Team;
import com.example.webblog.repository.TeamRepository;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@Transactional
class MemberServiceTest {

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  MemberRepository memberRepository;

  @Autowired
  MemberService memberService;

  @Autowired
  EntityManager em;

  @Test
  public void reserveMemberTeamChange() throws InterruptedException {
    // given
    generateTeam(DEFAULT_NAME);
    Team changeTeam = generateTeam("정현모");
    generateMember();
    generateMember();

    // when
    String result = memberService.reserveMemberTeamChange(1);

    // wait task running
    Thread.sleep(5000);

    // then
    assertThat(result).isEqualTo("SUCCESS");
    List<Member> resultMembers = memberRepository.findAll();
    assertThat(resultMembers.get(0).getTeam().getId()).isEqualTo(changeTeam.getId());
    assertThat(resultMembers.get(1).getTeam().getId()).isEqualTo(changeTeam.getId());

    // after
    deleteAllMember();
    deleteAllTeam();
  }

  private void deleteAllMember() {
    memberRepository.deleteAll();
  }

  private void deleteAllTeam() {
    teamRepository.deleteAll();
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