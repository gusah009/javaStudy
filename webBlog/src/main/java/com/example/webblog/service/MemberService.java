package com.example.webblog.service;

import static com.example.webblog.repository.Team.DEFAULT_NAME;
import static java.time.LocalDateTime.now;

import com.example.webblog.repository.Member;
import com.example.webblog.repository.MemberRepository;
import com.example.webblog.repository.Team;
import com.example.webblog.repository.TeamRepository;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

  public static final ZoneOffset SEOUL_ZONE_OFFSET = ZoneOffset.of("+09:00");

  private final SchedulerService schedulerService;
  private final MemberRepository memberRepository;
  private final TeamRepository teamRepository;

  private final TransactionTemplate transactionTemplate;

  @Transactional
  public String reserveMemberTeamChange(int seconds) {
    Date taskDate = getDatePlusSeconds(seconds);
    Runnable task = () -> changeDefaultTeamMembersTeamTo("정현모");
    schedulerService.scheduleTask(task, taskDate);

    return "SUCCESS";
  }

  private Date getDatePlusSeconds(int seconds) {
    return Date.from(now().plusSeconds(seconds).toInstant(SEOUL_ZONE_OFFSET));
  }

  private void changeDefaultTeamMembersTeamTo(String teamName) {
    List<Member> allMembers = memberRepository.findAll();
    Team myTeam = getTeamByName(teamName);
    for (Member member : allMembers) {
      // 조금 억지스럽지만, 추후에 있을 LazyInitializationException을 보여주기 위해 이름으로 비교
      if (Objects.equals(member.getTeam().getName(), DEFAULT_NAME)) {
        member.changeTeam(myTeam);
      }
    }
    memberRepository.saveAll(allMembers);
  }

  private Team getTeamByName(String teamName) {
    return teamRepository.findByName(teamName)
        .orElseThrow(RuntimeException::new);
  }
}
