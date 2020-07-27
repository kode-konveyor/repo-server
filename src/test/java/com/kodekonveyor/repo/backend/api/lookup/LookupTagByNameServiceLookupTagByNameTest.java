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
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.repo.api.LerpoiTestData;
import com.kodekonveyor.repo.api.SumtiDTOTestData;
import com.kodekonveyor.repo.api.SumtiEntityTagStubs;
import com.kodekonveyor.repo.backend.api.LerpoiEntityTagStubs;

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
    LerpoiEntityTagStubs.behaviour(lerpoiEntityTag);
    SumtiEntityTagStubs.behaviour(sumtiEntityTag);
    assertEquals(
        SumtiDTOTestData.get(),
        lookupTagByNameService.call(LerpoiTestData.NAME)
    );
  }

  @Test
  @DisplayName(
    "UUID of the Sumti is returned successfully"
  )
  void test1() {
    LerpoiEntityTagStubs.behaviour(lerpoiEntityTag);
    SumtiEntityTagStubs.behaviour(sumtiEntityTag);
    assertEquals(
        SumtiDTOTestData.get().getUuid(),
        lookupTagByNameService.call(LerpoiTestData.NAME).getUuid()
    );
  }

  @Test
  @DisplayName(
    "Lerpoi ID of the Sumti is returned successfully"
  )
  void test2() {
    LerpoiEntityTagStubs.behaviour(lerpoiEntityTag);
    SumtiEntityTagStubs.behaviour(sumtiEntityTag);
    assertEquals(
        SumtiDTOTestData.get().getLerpoi(),
        lookupTagByNameService.call(LerpoiTestData.NAME).getLerpoi()
    );
  }

  @Test
  @DisplayName(
    "Bridi ID of the Sumti is returned successfully"
  )
  void test3() {
    LerpoiEntityTagStubs.behaviour(lerpoiEntityTag);
    SumtiEntityTagStubs.behaviour(sumtiEntityTag);
    assertEquals(
        SumtiDTOTestData.get().getBridi(),
        lookupTagByNameService.call(LerpoiTestData.NAME).getBridi()
    );
  }

  @Test
  @DisplayName(
    "if sumti for given lerpoi does not exist in repository, we throw an exception"
  )
  void test4() {
    LerpoiEntityTagStubs.behaviour(lerpoiEntityTag);
    SumtiEntityTagStubs.sumtiNotExists(sumtiEntityTag);
    ThrowableTester
        .assertThrows(() -> lookupTagByNameService.call(LerpoiTestData.NAME))
        .assertMessageIs(
            LookupTagByNameTestData.SUMTI_NOT_FOUND_EXCEPTION_FOR_TAG_LOOKUP
        );

  }

  @Test
  @DisplayName(
    "if Lerpoi for given Name does not exist in repository, we throw an exception"
  )
  void test5() {
    LerpoiEntityTagStubs.lerpoiNotExists(lerpoiEntityTag);

    ThrowableTester
        .assertThrows(() -> lookupTagByNameService.call(LerpoiTestData.NAME))
        .assertMessageIs(
            LookupTagByNameTestData.LERPOI_NOT_FOUND_EXCEPTION_FOR_TAG_LOOKUP
        );

  }

}
