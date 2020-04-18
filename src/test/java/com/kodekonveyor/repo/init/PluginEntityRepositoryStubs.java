package com.kodekonveyor.repo.init;

import org.mockito.Mockito;

public class PluginEntityRepositoryStubs {

  public static void
      behaviour(final PluginEntityRepository pluginEntityRepository) {
    Mockito.when(pluginEntityRepository.findAll())
        .thenReturn(PluginEntityTestData.list());
  }
}
