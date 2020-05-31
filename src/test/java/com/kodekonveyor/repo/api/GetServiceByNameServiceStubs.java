package com.kodekonveyor.repo.api;

import org.mockito.Mockito;

import com.kodekonveyor.init.PluginEntityTestData;

public class GetServiceByNameServiceStubs {

  public static void
      behaviour(final GetServiceByNameService getServiceByNameService) {
    Mockito.reset(PluginEntityTestData.SERVICE_OBJECT);
    Mockito.when(
        getServiceByNameService.call(PluginEntityTestData.SERVICE_NAME)
    ).thenReturn(PluginEntityTestData.SERVICE_OBJECT);
  }

}
