package com.kodekonveyor.init;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.repo.api.GetServiceByNameService;
import com.kodekonveyor.repo.api.GetServiceByNameServiceStubs;

public class MetamodelCheckServiceTestBase {

  @Mock
  protected GetServiceByNameService getServiceByNameService;
  @InjectMocks
  protected MetamodelCheckService metamodelCheckService;
  @Mock
  protected PluginEntityRepository pluginEntityRepository;

  @BeforeEach
  void setUp() {
    GetServiceByNameServiceStubs.behaviour(getServiceByNameService);
    PluginEntityRepositoryStubs.behaviour(pluginEntityRepository);
  }
}
