package com.example.webblog.datainit;

import static com.example.webblog.repository.Team.DEFAULT_NAME;

import com.example.webblog.repository.Member;
import com.example.webblog.repository.MemberRepository;
import com.example.webblog.repository.Team;
import com.example.webblog.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class TestDataInit {

  private final TeamRepository teamRepository;
  private final MemberRepository memberRepository;

  /**
   * @formatter:off
   * 예제용 팀 없음 데이터 추가
   * 예제용 정현모 팀 데이터 추가
   * @formatter:on
   */
  @EventListener(ApplicationReadyEvent.class)
  public void init() {
    Team noTeam = teamRepository.save(Team.builder().name(DEFAULT_NAME).build());
    teamRepository.save(Team.builder().name("정현모").build());
    for (int i = 0; i < 3; i++) {
      memberRepository.save(
          Member.builder()
              .name("name_" + i)
              .team(noTeam)
              .build());
    }
  }
}
