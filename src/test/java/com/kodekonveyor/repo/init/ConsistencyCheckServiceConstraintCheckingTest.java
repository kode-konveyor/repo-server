package com.kodekonveyor.repo.init;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;

@TestedBehaviour("constraint checking")
@TestedService("ConsistencyCheckService")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
public class ConsistencyCheckServiceConstraintCheckingTest
    extends ConsistencyCheckServiceTestBase {

  @Override
  @BeforeEach
  void setUp() {
    super.setUp();
    consistencyCheckService.call(ModificationDTOTestData.get());
  }

  @Test
  @DisplayName("Looks up all the plugins")
  void test1() {

    Mockito.verify(pluginEntityRepository).findAll();
  }

  @Test
  @DisplayName("Looks up the metamodel check service by its name")
  void test2() {

    Mockito.verify(getServiceByNameService)
        .call(PluginEntityTestData.SERVICE_NAME);
  }

  @Test
  @DisplayName("ConsistencyCheckService is called with modifications")
  public void test3() {

    Mockito.verify((ConsistencyChecker) PluginEntityTestData.SERVICE_OBJECT)
        .call(ModificationDTOTestData.get());
  }
}
