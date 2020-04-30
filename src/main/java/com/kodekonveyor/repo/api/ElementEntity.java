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
class ElementEntity {

  private String commit;

  private String description;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String name;
  @OneToOne(fetch = FetchType.LAZY)
  private RepositoryEntity repo;

  private String sourceId;

  private String SourceTag;

  private String targetId;

  private String TargetTag;

}
