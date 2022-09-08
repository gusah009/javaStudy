package com.example.webblog.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Team {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
}
