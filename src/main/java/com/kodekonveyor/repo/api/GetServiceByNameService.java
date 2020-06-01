package com.kodekonveyor.repo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekonveyor.webapp.WebAppInitializer;

@Service
public class GetServiceByNameService {

  @Autowired
  private WebAppInitializer webAppInitializer;

  public Object call(final String serviceName) {
    return webAppInitializer.getContext().getBean(serviceName);
  }

}
