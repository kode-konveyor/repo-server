package com.kodekonveyor.repo.api;

import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ModifyElementControllerTestBase {

  @Mock
  protected LookupDeletedAndModifiedElementsService lookupDeletedAndModifiedElementsService;
  @InjectMocks
  protected ModifyElementController modifyElementController;

}
