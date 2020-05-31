package com.kodekonveyor.repo.api;

import org.mockito.Mockito;

import com.kodekonveyor.init.MetamodelChecker;
import com.kodekonveyor.init.PluginEntityTestData;

public class GetServiceByNameServiceStubs {

  public static void
      behaviour(final GetServiceByNameService getServiceByNameService) {
    PluginEntityTestData.SERVICE_OBJECT = Mockito.mock(MetamodelChecker.class);
    Mockito.when(
        getServiceByNameService.call(PluginEntityTestData.SERVICE_NAME)
    ).thenReturn(PluginEntityTestData.SERVICE_OBJECT);
  }

}
