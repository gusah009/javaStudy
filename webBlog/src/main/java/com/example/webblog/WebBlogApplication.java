package com.example.webblog;

import com.example.webblog.datainit.TestDataInit;
import com.example.webblog.repository.MemberRepository;
import com.example.webblog.repository.TeamRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class WebBlogApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebBlogApplication.class, args);
  }

  @Bean
  @Profile("dev")
  public TestDataInit testDataInit(TeamRepository teamRepository,
      MemberRepository memberRepository) {
    return new TestDataInit(teamRepository, memberRepository);
  }
}
