package com.kodekonveyor.repo.api;

public class RepositoryEntityTestData {

  public static RepositoryEntity get() {
    final RepositoryEntity entity = new RepositoryEntity();
    entity.setId("elementId");
    entity.setUrl("https://repo.kodekonveyor.com/core");
    entity.setOwner(ElementEntityTestData.getOwner());

    return entity;
  }

}
