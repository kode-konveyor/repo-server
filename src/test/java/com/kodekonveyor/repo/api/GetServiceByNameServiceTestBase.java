package com.kodekonveyor.repo.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.webapp.WebAppInitializer;
import com.kodekonveyor.webapp.WebAppInitializerStubs;

public class GetServiceByNameServiceTestBase {

  @InjectMocks
  protected GetServiceByNameService getServiceByNameService;
  @Mock
  WebAppInitializer webAppInitializer;

  @BeforeEach
  public void setUp() {
    WebAppInitializerStubs.behaviour(webAppInitializer);
  }

}
