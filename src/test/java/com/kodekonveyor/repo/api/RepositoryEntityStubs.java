package com.kodekonveyor.repo.api;

import java.util.List;

import org.mockito.Mockito;

public class RepositoryEntityStubs {

  public static void
      behaviour(final RepositoryEntityRepository repositoryEntityRepository) {
    Mockito.reset(repositoryEntityRepository);
    Mockito.doReturn(List.of(RepositoryEntityTestData.get())).when(
        repositoryEntityRepository
    ).findByOwner(ElementEntityTestData.get());

  }

}
