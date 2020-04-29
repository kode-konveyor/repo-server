package com.kodekonveyor.repo.api;

public class ElementEntityTestHelper {
  public static ElementEntity buildElementEntity(final String id,final String commit,final String source,final String target) {//NOPMD
    final ElementEntity element = new ElementEntity();
    element.setId(id);
    element.setCommit(commit);
    element.setSource(source);
    element.setTarget(target);
    return element;
  }
}
