package com.example.webblog.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString // 예제를 돕기 위해 추가
@EqualsAndHashCode // 예제를 돕기 위해 추가
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

  public static final String DEFAULT_NAME = "팀 없음";

  @Id
  @GeneratedValue
  private Long id;

  private String name;
}
