package com.kodekonveyor.repo.api;

public class ElementDTOTestData {
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

  private static ElementDTO buildElementDTO(final String id,final String commit,final String source,final String target) {// NOPMD
    final ElementDTO element = new ElementDTO();
    element.setId(id);
    element.setCommit(commit);
    element.setSource(source);
    element.setTarget(target);
    return element;
  }
  public static ElementDTO get() {
    return buildElementDTO(FOUND_LOCAL_ID, FOUND_LOCAL_COMMIT, SOURCE_FOUND_LOCAL, TARGET_FOUND_LOCAL);
  }
  public static ElementDTO getWithWrongSyntax() {
    return buildElementDTO(SYNTAX_ID, SYNTAX_COMMIT, SYNTAX, SYNTAX);
  }
  public static ElementDTO getFoundServer() {
    return buildElementDTO(FOUND_SERVER_ID, FOUND_SERVER_COMMIT, SOURCE_FOUND_SERVER, TARGET_FOUND_SERVER);
  }
  public static ElementDTO getRemote() {
    return buildElementDTO(REMOTE_ID, REMOTE_COMMIT, SOURCE_REMOTE, TARGET_REMOTE);
  }
  public static ElementDTO getNotFoundLocal() {
    return buildElementDTO(NOT_FOUND_LOCAL_ID, NOT_FOUND_LOCAL_COMMIT, SOURCE_NOT_FOUND_LOCAL, TARGET_NOT_FOUND_LOCAL);
  }
  public static ElementDTO getNotFoundServer() {
    return buildElementDTO(NOT_FOUND_SERVER_ID, NOT_FOUND_SERVER_COMMIT, SOURCE_NOT_FOUND_SERVER, TARGET_NOT_FOUND_SERVER);
  }
}
