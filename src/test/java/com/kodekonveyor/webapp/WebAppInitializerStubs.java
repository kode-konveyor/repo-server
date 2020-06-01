package com.kodekonveyor.webapp;

import org.mockito.Mockito;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.repo.api.ApiTestData;

public class WebAppInitializerStubs {

  public static void behaviour(final WebAppInitializer webAppInitializer) {
    final XmlWebApplicationContext context = //NOPMD
        Mockito.mock(XmlWebApplicationContext.class);
    Mockito.doReturn(context).when(webAppInitializer).getContext();
    final Object toBeReturned = new AuthenticatedUserService();
    Mockito.doReturn(toBeReturned).when(context)
        .getBean(ApiTestData.METAMODEL_CHECK_SERVICE_NAME);
  }

}
