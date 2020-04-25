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

  @BeforeEach
  public void setup() {

    doReturn(CheckReferenceResultEnum.FOUND_LOCAL).when(checkReferenceService).call(any(),Mockito.eq("sourceFoundLocal"));
    doReturn(CheckReferenceResultEnum.FOUND_LOCAL).when(checkReferenceService).call(any(),Mockito.eq("targetFoundLocal"));
    doReturn(CheckReferenceResultEnum.SYNTAX).when(checkReferenceService).call(any(),Mockito.eq("syntax"));
    doReturn(Optional.ofNullable(ElementEntityTestData.get())).when(elementRepository).findById(ElementDTOTestData.FOUND_LOCAL_ID);
    doReturn(Optional.ofNullable(ElementEntityTestData.getWithWrongSyntax())).when(elementRepository).findById(ElementDTOTestData.SYNTAX_ID);

    doReturn(CheckReferenceResultEnum.FOUND_SERVER).when(checkReferenceService).call(any(),Mockito.eq("sourceFoundServer"));
    doReturn(CheckReferenceResultEnum.FOUND_SERVER).when(checkReferenceService).call(any(),Mockito.eq("targetFoundServer"));
    doReturn(Optional.ofNullable(ElementEntityTestData.getFoundServer())).when(elementRepository).findById(ElementDTOTestData.FOUND_SERVER_ID);

    doReturn(CheckReferenceResultEnum.REMOTE).when(checkReferenceService).call(any(),Mockito.eq("sourceRemote"));
    doReturn(CheckReferenceResultEnum.REMOTE).when(checkReferenceService).call(any(),Mockito.eq("targetRemote"));
    doReturn(Optional.ofNullable(ElementEntityTestData.getRemote())).when(elementRepository).findById(ElementDTOTestData.REMOTE_ID);

    doReturn(CheckReferenceResultEnum.NOT_FOUND_LOCAL).when(checkReferenceService).call(any(),Mockito.eq("sourceNotFoundLocal"));
    doReturn(CheckReferenceResultEnum.NOT_FOUND_LOCAL).when(checkReferenceService).call(any(),Mockito.eq("targetNotFoundLocal"));
    doReturn(Optional.ofNullable(ElementEntityTestData.getNotFoundLocal())).when(elementRepository).findById(ElementDTOTestData.NOT_FOUND_LOCAL_ID);

    doReturn(CheckReferenceResultEnum.NOT_FOUND_SERVER).when(checkReferenceService).call(any(),Mockito.eq("sourceNotFoundServer"));
    doReturn(CheckReferenceResultEnum.NOT_FOUND_SERVER).when(checkReferenceService).call(any(),Mockito.eq("targetNotFoundServer"));
    doReturn(Optional.ofNullable(ElementEntityTestData.getNotFoundServer())).when(elementRepository).findById(ElementDTOTestData.NOT_FOUND_SERVER_ID);


  }


}
