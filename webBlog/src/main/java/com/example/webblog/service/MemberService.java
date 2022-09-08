package com.example.webblog.service;

import static java.time.LocalDateTime.now;

import com.example.webblog.repository.Member;
import com.example.webblog.repository.MemberRepository;
import com.example.webblog.repository.Team;
import com.example.webblog.repository.TeamRepository;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

  public static final ZoneOffset SEOUL_ZONE_OFFSET = ZoneOffset.of("+09:00");

  private final SchedulerService schedulerService;
  private final MemberRepository memberRepository;
  private final TeamRepository teamRepository;

  @Transactional
  public String reserveMemberNameChange(int seconds) {
    Date taskDate = getDatePlusSeconds(seconds);
    Runnable task = changeEveryMemberTeamTo("정현모");
    schedulerService.scheduleTask(task, taskDate);

    return "SUCCESS";
  }

  private Date getDatePlusSeconds(int seconds) {
    return Date.from(now().plusSeconds(seconds).toInstant(SEOUL_ZONE_OFFSET));
  }

  private Runnable changeEveryMemberTeamTo(String teamName) {
    return () -> {
      List<Member> allMembers = memberRepository.findAll();
      Team myTeam = getTeamByName(teamName);
      for (Member member : allMembers) {
        member.changeTeam(myTeam);
      }
      memberRepository.saveAll(allMembers);
    };
  }

  private Team getTeamByName(String teamName) {
    return teamRepository.findByName(teamName)
        .orElseThrow(RuntimeException::new);
  }
}
