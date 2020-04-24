package com.kodekonveyor.repo.api;

public class ElementEntityTestData {

  public final static String COMMIT_ID = "commitId";

  public final static String DESCRIPTION =
      "The description\\n can be more lines";

  public final static String ID = "elementId";

  public final static String NAME = "element name";

  public final static String SOURCE_ID = "elementId";

  public final static String SOURCE_TAG = "SourceTag";

  public final static String TARGET_ID = "elementId";

  public final static String TARGET_TAG = "TargetTag";

  public static ElementEntity get() {

    final ElementEntity entity = new ElementEntity();
    entity.setCommit(COMMIT_ID);
    entity.setDescription(DESCRIPTION);
    entity.setId(ID);
    entity.setName(NAME);
    entity.setSourceId(SOURCE_ID);
    entity.setTargetId(TARGET_ID);
    entity.setSourceTag(SOURCE_TAG);
    entity.setTargetTag(TARGET_TAG);
    //entity.setRepo(RepositoryEntityTestData.get());

    return entity;
  }

  public static ElementEntity getOwner() {
    final ElementEntity entity = new ElementEntity();
    entity.setCommit(COMMIT_ID);
    entity.setDescription(DESCRIPTION);
    entity.setId(ID);
    entity.setName(NAME);
    entity.setSourceId(SOURCE_ID);
    entity.setTargetId(TARGET_ID);
    entity.setSourceTag(SOURCE_TAG);
    entity.setTargetTag(TARGET_TAG);
    return entity;
  }
}
