package com.kodekonveyor.repo.api;


public class ElementDTOTestData {

  public static final String SYNTAX_ID = "SyntaxID";
  public static final String FOUND_LOCAL_ID = "FOUND_LOCAL";
  public static final String FOUND_SERVER_ID = "FOUND_SERVER";
  public static final String REMOTE_ID = "REMOTE";
  public static final String NOT_FOUND_LOCAL_ID = "NOT_FOUND_LOCAL";
  public static final String NOT_FOUND_SERVER_ID = "NOT_FOUND_SERVER";



  public static ElementDTO get() {
    final ElementDTO element = new ElementDTO();
    element.setCommit("commit");
    element.setSource("sourceFoundLocal");
    element.setTarget("targetFoundLocal");
    element.setId(FOUND_LOCAL_ID);

    return element;
  }

  public static ElementDTO getWithWrongSyntax() {
    final ElementDTO element = new ElementDTO();
    element.setCommit("commit");
    element.setSource("syntax");
    element.setTarget("syntax");
    element.setId(SYNTAX_ID);

    return element;
  }
  public static ElementDTO getFoundServer() {
    final ElementDTO element = new ElementDTO();
    element.setCommit("commit");
    element.setSource("sourceFoundServer");
    element.setTarget("targetFoundServer");
    element.setId(FOUND_SERVER_ID);

    return element;
  }
  public static ElementDTO getRemote() {
    final ElementDTO element = new ElementDTO();
    element.setCommit("commit");
    element.setSource("sourceRemote");
    element.setTarget("targetRemote");
    element.setId(REMOTE_ID);

    return element;
  }

  public static ElementDTO getNotFoundLocal() {
    final ElementDTO element = new ElementDTO();
    element.setCommit("commit");
    element.setSource("sourceNotFoundLocal");
    element.setTarget("targetNotFoundLocal");
    element.setId(NOT_FOUND_LOCAL_ID);

    return element;
  }

  public static ElementDTO getNotFoundServer() {
    final ElementDTO element = new ElementDTO();
    element.setCommit("commit");
    element.setSource("sourceNotFoundServer");
    element.setTarget("targetNotFoundServer");
    element.setId(NOT_FOUND_SERVER_ID);

    return element;
  }

}
