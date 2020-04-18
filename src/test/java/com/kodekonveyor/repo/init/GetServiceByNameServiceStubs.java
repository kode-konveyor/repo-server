package com.kodekonveyor.repo.init;

import org.mockito.Mockito;

public class GetServiceByNameServiceStubs {

  public static void
      behaviour(final GetServiceByNameService getServiceByNameService) {
    // TODO Auto-generated method stub
    PluginEntityTestData.SERVICE_OBJECT =
        Mockito.mock(ConsistencyChecker.class);
    Mockito.when(
        getServiceByNameService.call(PluginEntityTestData.SERVICE_NAME)
    ).thenReturn(PluginEntityTestData.SERVICE_OBJECT);
  }

}
