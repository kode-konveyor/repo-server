package com.kodekonveyor.repo.api;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.repo.init.ConsistencyCheckService;

public class ModifyElementControllerTestBase {

  @Mock
  protected ConsistencyCheckService consistencyCheckService;
  @InjectMocks
  protected ModifyElementController modifyElementController;

}
