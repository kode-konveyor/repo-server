package com.kodekonveyor.repo.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class RepositoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private ElementEntity owner;
  private String url;
}
