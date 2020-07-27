package com.kodekonveyor.repo.backend.api;

import java.util.Optional;

import org.mockito.Mockito;

import com.kodekonveyor.repo.api.LerpoiEntityTag;
import com.kodekonveyor.repo.api.LerpoiEntityTestData;
import com.kodekonveyor.repo.api.LerpoiTestData;

public class LerpoiEntityTagStubs {

  public static void
      behaviour(final LerpoiEntityTag lerpoiEntityTag) {
    Mockito.doReturn(Optional.of(LerpoiEntityTestData.get()))
        .when(lerpoiEntityTag)
        .findByName(LerpoiTestData.NAME);

  }

  public static void
      lerpoiNotExists(final LerpoiEntityTag lerpoiEntityTag) {

    Mockito.doReturn(Optional.empty())
        .when(lerpoiEntityTag)
        .findByName(LerpoiTestData.NAME);
  }
}
