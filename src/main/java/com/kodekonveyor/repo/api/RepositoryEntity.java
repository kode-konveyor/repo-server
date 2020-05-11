package com.kodekonveyor.repo.api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity

public class RepositoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  @OneToOne(fetch = FetchType.LAZY)
  private ElementEntity owner;
  private String url;
}
