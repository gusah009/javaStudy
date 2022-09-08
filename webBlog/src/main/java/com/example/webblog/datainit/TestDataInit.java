package com.example.webblog.datainit;

import com.example.webblog.repository.Team;
import com.example.webblog.repository.TeamRepository;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

  private final TeamRepository teamRepository;

  /**
   * 예제용 정현모 팀 데이터 추가
   */
  @PostConstruct
  public void init() {
    teamRepository.save(Team.builder().name("정현모").build());
  }

}
