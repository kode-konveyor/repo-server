package com.kodekonveyor.repo.init;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ConsistencyCheckServiceTestBase {

  @InjectMocks
  protected ConsistencyCheckService consistencyCheckService;
  @Mock
  protected GetServiceByNameService getServiceByNameService;
  @Mock
  protected PluginEntityRepository pluginEntityRepository;

  @BeforeEach
  void setUp() {
    GetServiceByNameServiceStubs.behaviour(getServiceByNameService);
    PluginEntityRepositoryStubs.behaviour(pluginEntityRepository);
  }

}
