package com.kodekonveyor.repo.api;

public class ElementEntityTestData {

  public static ElementEntity get() {
    final ElementEntity entity = new ElementEntity();
    entity.setCommit("commitId");
    entity.setDescription("The description\\n can be more lines");
    entity.setId("elementId");
    entity.setName("element name");
    entity.setSourceId("elementId");
    entity.setTargetId("elementId");
    // entity.setRepo(RepositoryEntityTestData.get());

    return entity;
  }

}
