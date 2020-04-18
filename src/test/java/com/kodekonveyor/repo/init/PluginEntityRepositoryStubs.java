package com.kodekonveyor.repo.init;

import org.mockito.Mockito;

public class PluginEntityRepositoryStubs {

  public static void
      behaviour(final PluginEntityRepository pluginEntityRepository) {
    // TODO Auto-generated method stub
    Mockito.when(pluginEntityRepository.findAll())
        .thenReturn(PluginEntityTestData.list());
  }
}
