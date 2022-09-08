package com.example.webblog.controller;

import com.example.webblog.service.MemberService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/reserve")
  public String reserveMemberNameChange(
      @RequestParam @NotNull Integer seconds
  ) {
    return memberService.reserveMemberNameChange(seconds);
  }

}
