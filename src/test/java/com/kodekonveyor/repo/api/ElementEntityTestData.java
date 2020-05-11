package com.kodekonveyor.repo.api;

public class ElementEntityTestData {
  public static final String TARGET_NOT_FOUND_SERVER = "targetNotFoundServer";
  public static final String SOURCE_NOT_FOUND_SERVER = "sourceNotFoundServer";
  public static final String NOT_FOUND_SERVER_COMMIT = "notFoundServerCommit";
  public static final String TARGET_NOT_FOUND_LOCAL = "targetNotFoundLocal";
  public static final String SOURCE_NOT_FOUND_LOCAL = "sourceNotFoundLocal";
  public static final String NOT_FOUND_LOCAL_COMMIT = "notFoundLocalCommit";
  public static final String TARGET_REMOTE = "targetRemote";
  public static final String SOURCE_REMOTE = "sourceRemote";
  public static final String REMOTE_COMMIT = "remoteCommit";
  public static final String TARGET_FOUND_SERVER = "targetFoundServer";
  public static final String SOURCE_FOUND_SERVER = "sourceFoundServer";
  public static final String FOUND_SERVER_COMMIT = "foundServerCommit";
  public static final String SYNTAX = "syntax";
  public static final String SYNTAX_COMMIT = "syntaxCommit";
  public static final String TARGET_FOUND_LOCAL = "targetFoundLocal";
  public static final String SOURCE_FOUND_LOCAL = "sourceFoundLocal";
  public static final String FOUND_LOCAL_COMMIT = "foundLocalCommit";
  public static final String SYNTAX_ID = "SyntaxID";
  public static final String FOUND_LOCAL_ID = "FOUND_LOCAL";
  public static final String FOUND_SERVER_ID = "FOUND_SERVER";
  public static final String REMOTE_ID = "REMOTE";
  public static final String NOT_FOUND_LOCAL_ID = "NOT_FOUND_LOCAL";
  public static final String NOT_FOUND_SERVER_ID = "NOT_FOUND_SERVER";

  public static ElementEntity get() {
    return ElementEntityTestHelper.buildElementEntity(FOUND_LOCAL_ID, FOUND_LOCAL_COMMIT, SOURCE_FOUND_LOCAL, TARGET_FOUND_LOCAL);
  }
  public static ElementEntity getWithWrongSyntax() {
    return ElementEntityTestHelper.buildElementEntity(SYNTAX_ID, SYNTAX_COMMIT, SYNTAX, SYNTAX);
  }
  public static ElementEntity getFoundServer() {
    return ElementEntityTestHelper.buildElementEntity(FOUND_SERVER_ID, FOUND_SERVER_COMMIT, SOURCE_FOUND_SERVER, TARGET_FOUND_SERVER);
  }
  public static ElementEntity getRemote() {
    return ElementEntityTestHelper.buildElementEntity(REMOTE_ID, REMOTE_COMMIT, SOURCE_REMOTE, TARGET_REMOTE);
  }
  public static ElementEntity getNotFoundLocal() {
    return ElementEntityTestHelper.buildElementEntity(NOT_FOUND_LOCAL_ID, NOT_FOUND_LOCAL_COMMIT, SOURCE_NOT_FOUND_LOCAL, TARGET_NOT_FOUND_LOCAL);
  }
  public static ElementEntity getNotFoundServer() {
    return ElementEntityTestHelper.buildElementEntity(NOT_FOUND_SERVER_ID, NOT_FOUND_SERVER_COMMIT, SOURCE_NOT_FOUND_SERVER, TARGET_NOT_FOUND_SERVER);

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
    entity.setRepo(RepositoryEntityTestData.get());

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
