package com.kodekonveyor.repo.api;

public class ElementDTOTestData {

  public static final String COMMIT_ID = "commitId";
  public static final String ELEMENT_ID = "elementId";
  public static final String ELEMENT_NAME = "element name";
  public static final String SOURCE_TAG = "SourceTag";
  public static final String TARGET_TAG = "TargetTag";
  public static final String THE_DESCRIPTION_N_CAN_BE_MORE_LINES =
      "The description\\n can be more lines";

  public static ElementDTO get() {

    final ElementDTO entity = new ElementDTO();
    entity.setCommit(COMMIT_ID);
    entity.setDescription(THE_DESCRIPTION_N_CAN_BE_MORE_LINES);
    entity.setId(ELEMENT_ID);
    entity.setName(ELEMENT_NAME);
    entity.setSourceId(ELEMENT_ID);
    entity.setTargetId(ELEMENT_ID);
    entity.setSourceTag(SOURCE_TAG);
    entity.setTargetTag(TARGET_TAG);
    return entity;
  }

}
