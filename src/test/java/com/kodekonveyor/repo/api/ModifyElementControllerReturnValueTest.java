package com.kodekonveyor.repo.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)

@TestedBehaviour("return value")
@TestedService("ModifyElementController")
class ModifyElementControllerReturnValueTest
    extends ModifyElementControllerTestBase {

  @InjectMocks
  ModifyElementController modifyelementController;

  @Test
  @DisplayName("Check if DTO is Returned")
  void test() {
    final ModificationDTO modificationdto = new ModificationDTO();

    final ModificationDTO result =
        modifyelementController.call(11l, modificationdto);
    assertEquals(modificationdto, result);

  }

}
