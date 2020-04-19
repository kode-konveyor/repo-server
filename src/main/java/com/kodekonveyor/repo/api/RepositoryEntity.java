package com.kodekonveyor.repo.api;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class RepositoryEntity {
  private String url;
  private ElementEntity owner;

}
