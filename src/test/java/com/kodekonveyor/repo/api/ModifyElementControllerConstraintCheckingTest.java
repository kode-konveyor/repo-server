package com.kodekonveyor.repo.api;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("constraint checking")
@TestedService("ModifyElementController")
public class ModifyElementControllerConstraintCheckingTest extends ModifyElementControllerTestBase {

  @Test
  @DisplayName("ConsistencyCheckService is called with modifications")
  public void test() {
    modifyElementController.call(ModificationDTOTestData.get(), null);
    verify(consistencyCheckService)
        .call(
            ModificationDTOTestData.get()
        );
  }
}
