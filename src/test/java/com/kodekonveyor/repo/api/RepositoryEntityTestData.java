package com.kodekonveyor.repo.api;

public class RepositoryEntityTestData {
  public static final String FOUND_LOCAL_REPO_NAME = "foundLocalRepoName";
  public static final String FOUND_LOCAL_TAG_NAME = "foundLocalTagName";
  public static final String NOT_FOUND_SERVER_TAG_NAME = "notFoundServerTagName";
  public static final String NOT_FOUND_SERVER_REPO_NAME = "notFoundServerRepoName";
  public static final String NOT_FOUND_LOCAL_TAG_NAME = "notFoundLocalTagName";
  public static final String NOT_FOUND_LOCAL_REPO_NAME = "notFoundLocalRepoName";
  public static final String REMOTE_TAG_NAME = "remoteTagName";
  public static final String REMOTE_REPO_NAME = "remoteRepoName";
  public static final String FOUND_SERVER_TAG_NAME = "foundServerTagName";
  public static final String FOUND_SERVER_REPO_NAME = "foundServerRepoName";
  public static final String SYNTAX_TAG_NAME = "syntaxTagName";
  public static final String SYNTAX_REPO_NAME = "syntaxRepoName";

  public static RepositoryEntity get() {
    final RepositoryEntity entity = new RepositoryEntity();
    entity.setId("elementId");
    entity.setUrl("https://repo.kodekonveyor.com/core");
    entity.setOwner(ElementEntityTestData.getOwner());

    return entity;
  }

}
