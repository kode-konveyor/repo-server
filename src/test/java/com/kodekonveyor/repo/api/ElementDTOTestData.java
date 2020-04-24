package com.kodekonveyor.repo.api;

public class ElementDTOTestData {

  public static ElementDTO get() {

    final ElementDTO entity = new ElementDTO();
    entity.setCommit("commitId");
    entity.setDescription("The description\\n can be more lines");
    entity.setId("elementId");
    entity.setName("element name");
    entity.setSourceId("elementId");
    entity.setTargetId("elementId");
    entity.setSourceTag("SourceTag");
    entity.setTargetTag("TargetTag");
    return entity;
  }

}
