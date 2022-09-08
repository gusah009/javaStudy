package com.example.webblog.repository;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString // 예제를 돕기 위해 추가
@EqualsAndHashCode // 예제를 돕기 위해 추가
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  @Setter
  private String name;

  private int age;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn
  private Team team;

  public void changeTeam(Team team) {
    this.team = team;
  }
}
