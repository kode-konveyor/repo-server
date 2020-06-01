package com.kodekonveyor.repo.api;

import static org.junit.Assert.assertEquals;

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
import com.kodekonveyor.authentication.AuthenticatedUserService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("obtain bean")
@TestedService("GetServiceByNameService")
public class GetServiceByNameServiceObtainBeanTest extends GetServiceByNameServiceTestBase {

  @Test
  @DisplayName("An instance of the named class is returned")
  void test1() {
    final String serviceName = ApiTestData.METAMODEL_CHECK_SERVICE_NAME;
    final Object results = getServiceByNameService.call(serviceName);
    assertEquals(AuthenticatedUserService.class, results.getClass());
  }

}
