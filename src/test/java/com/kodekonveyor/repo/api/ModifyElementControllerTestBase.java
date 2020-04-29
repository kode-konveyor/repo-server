package com.kodekonveyor.repo.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ModifyElementControllerTestBase {

  @Mock
  CheckReferenceService checkReferenceService;

  @Mock
  ElementRepository elementRepository;

  @InjectMocks
  ModifyElementController modifyElementController;

  private void setupCase(final CheckReferenceResultEnum checkReferenceResultEnum, final String sourceReference, final String targetReference,final
      ElementEntity elementEntity) {
    doReturn(checkReferenceResultEnum).when(checkReferenceService).call(any(),Mockito.eq(sourceReference));
    doReturn(checkReferenceResultEnum).when(checkReferenceService).call(any(),Mockito.eq(targetReference));
    doReturn(Optional.ofNullable(elementEntity)).when(elementRepository).findById(elementEntity.getId());
  }
  @BeforeEach
  public void setup() {
    setupCase(CheckReferenceResultEnum.FOUND_LOCAL, ElementEntityTestData.SOURCE_FOUND_LOCAL, ElementEntityTestData.TARGET_FOUND_LOCAL, ElementEntityTestData.get());
    setupCase(CheckReferenceResultEnum.SYNTAX, ElementEntityTestData.SYNTAX, ElementEntityTestData.SYNTAX, ElementEntityTestData.getWithWrongSyntax());
    setupCase(CheckReferenceResultEnum.FOUND_SERVER, ElementEntityTestData.SOURCE_FOUND_SERVER, ElementEntityTestData.TARGET_FOUND_SERVER, ElementEntityTestData.getFoundServer());
    setupCase(CheckReferenceResultEnum.REMOTE, ElementEntityTestData.SOURCE_REMOTE, ElementEntityTestData.TARGET_REMOTE, ElementEntityTestData.getRemote());
    setupCase(CheckReferenceResultEnum.NOT_FOUND_LOCAL, ElementEntityTestData.SOURCE_NOT_FOUND_LOCAL, ElementEntityTestData.TARGET_NOT_FOUND_LOCAL, ElementEntityTestData.getNotFoundLocal());
    setupCase(CheckReferenceResultEnum.NOT_FOUND_SERVER, ElementEntityTestData.SOURCE_NOT_FOUND_SERVER, ElementEntityTestData.TARGET_NOT_FOUND_SERVER, ElementEntityTestData.getNotFoundServer());
  }
}
