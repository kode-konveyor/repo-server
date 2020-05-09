package com.kodekonveyor.init;

import org.mockito.Mockito;

public class GetServiceByNameServiceStubs {

  public static void
      behaviour(final GetServiceByNameService getServiceByNameService) {
    PluginEntityTestData.SERVICE_OBJECT = Mockito.mock(MetamodelChecker.class);
    Mockito.when(
        getServiceByNameService.call(PluginEntityTestData.SERVICE_NAME)
    ).thenReturn(PluginEntityTestData.SERVICE_OBJECT);
  }

}
