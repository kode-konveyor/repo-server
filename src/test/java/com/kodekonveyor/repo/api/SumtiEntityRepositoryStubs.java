package com.kodekonveyor.repo.api;

import java.util.List;

import org.mockito.Mockito;

import com.kodekonveyor.repo.api.SumtiEntityRepository;

public class SumtiEntityRepositoryStubs {

  public static void
      behaviour(final SumtiEntityRepository sumtiEntityRepository) {
    Mockito.doReturn(List.of(SumtiEntityTestData.get()))
        .when(sumtiEntityRepository).findByLerpoi(LerpoiEntityTestData.get());
  }

  public static void
      sumtiNotExists(final SumtiEntityRepository sumtiEntityRepository) {
    Mockito.doReturn(List.of())
        .when(sumtiEntityRepository).findByLerpoi(LerpoiEntityTestData.get());

  }

}
