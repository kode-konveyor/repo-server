package com.kodekonveyor.repo.backend.api.lookup;

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
import com.kodekonveyor.repo.api.LerpoiTestData;
import com.kodekonveyor.repo.api.SumtiDTOTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("lookup tag by name")
@TestedService("LookupTagByNameService")
public class LookupTagByNameServiceLookupTagByNameTest
    extends LookupTagByNameServiceTestBase {

  @Test
  @DisplayName(
    "looks up the sumti which is a tag, with the lerpoi given"
  )
  void test() {
    if (lookupTagByNameService.call(LerpoiTestData.NAME).size() > 0)
      assertEquals(
          SumtiDTOTestData.get(),
          lookupTagByNameService.call(LerpoiTestData.NAME).get(0)
      );
  }

  @Test
  @DisplayName(
    "UUID of the Sumti is returned successfully"
  )
  void test1() {
    if (lookupTagByNameService.call(LerpoiTestData.NAME).size() > 0)
      assertEquals(
          SumtiDTOTestData.get().getUuid(),
          lookupTagByNameService.call(LerpoiTestData.NAME).get(0).getUuid()
      );
  }

  @Test
  @DisplayName(
    "Lerpoi ID of the Sumti is returned successfully"
  )
  void test2() {
    if (lookupTagByNameService.call(LerpoiTestData.NAME).size() > 0)
      assertEquals(
          SumtiDTOTestData.get().getLerpoi(),
          lookupTagByNameService.call(LerpoiTestData.NAME).get(0).getLerpoi()
      );
  }

  @Test
  @DisplayName(
    "Bridi ID of the Sumti is returned successfully"
  )
  void test3() {
    if (lookupTagByNameService.call(LerpoiTestData.NAME).size() > 0)
      assertEquals(
          SumtiDTOTestData.get().getBridi(),
          lookupTagByNameService.call(LerpoiTestData.NAME).get(0).getBridi()
      );
  }

}
