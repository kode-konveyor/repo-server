package com.kodekonveyor.repo.api;

public class RepositoryEntityTestData {

  public static final String ELEMENT_ID = "elementId";
  public static final String HTTPS_REPO_KODEKONVEYOR_COM_CORE =
      "https://repo.kodekonveyor.com/core";

  public static RepositoryEntity get() {
    final RepositoryEntity entity = new RepositoryEntity();
    entity.setId(ELEMENT_ID);
    entity.setUrl(HTTPS_REPO_KODEKONVEYOR_COM_CORE);
    entity.setOwner(ElementEntityTestData.getOwner());

    return entity;
  }

}
