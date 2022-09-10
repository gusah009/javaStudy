package com.example.webblog.controller;

import com.example.webblog.service.MemberService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/reserve")
  public String reserveMemberTeamChange(
      @RequestBody @NotNull Integer seconds
  ) {
    return memberService.reserveMemberTeamChange(seconds);
  }
}
