package com.kodekonveyor.repo.api;

import java.util.Optional;

import org.mockito.Mockito;

public class SumtiEntityTagStubs {

  public static void
      behaviour(final SumtiEntityTag sumtiEntityTag) {
    Mockito.doReturn(Optional.of(SumtiEntityTestData.get()))
        .when(sumtiEntityTag).findByLerpoi(LerpoiEntityTestData.get());
  }

  public static void
      sumtiNotExists(final SumtiEntityTag sumtiEntityTag) {
    Mockito.doReturn(Optional.empty())
        .when(sumtiEntityTag).findByLerpoi(LerpoiEntityTestData.get());

  }
}
