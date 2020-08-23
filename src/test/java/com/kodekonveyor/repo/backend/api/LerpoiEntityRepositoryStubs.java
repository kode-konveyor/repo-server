package com.kodekonveyor.repo.backend.api;

import java.util.Optional;

import org.mockito.Mockito;

import com.kodekonveyor.repo.api.LerpoiEntityRepository;
import com.kodekonveyor.repo.api.LerpoiEntityTestData;
import com.kodekonveyor.repo.api.LerpoiTestData;

public class LerpoiEntityRepositoryStubs {

  public static void
      behaviour(final LerpoiEntityRepository lerpoiEntityRepository) {
    Mockito.doReturn(Optional.of(LerpoiEntityTestData.get()))
        .when(lerpoiEntityRepository)
        .findByName(LerpoiTestData.NAME);

  }

  public static void
      lerpoiNotExists(final LerpoiEntityRepository lerpoiEntityRepository) {

    Mockito.doReturn(Optional.empty())
        .when(lerpoiEntityRepository)
        .findByName(LerpoiTestData.NAME);
  }

}