package com.kodekonveyor.repo.api;

import java.util.Optional;

import org.mockito.Mockito;

public class SumtiEntityRepositoryStubs {

  public static void
      behaviour(final SumtiEntityRepository sumtiEntityRepository) {
    Mockito.doReturn(Optional.of(SumtiEntityTestData.get()))
        .when(sumtiEntityRepository).findByLerpoi(LerpoiEntityTestData.get());
  }

  public static void
      sumtiNotExists(final SumtiEntityRepository sumtiEntityRepository) {
    Mockito.doReturn(Optional.empty())
        .when(sumtiEntityRepository).findByLerpoi(LerpoiEntityTestData.get());

  }

}
