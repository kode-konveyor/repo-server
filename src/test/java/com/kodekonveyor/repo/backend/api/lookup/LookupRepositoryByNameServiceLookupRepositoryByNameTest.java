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
import com.kodekonveyor.repo.api.SumtiEntityRepositoryStubs;
import com.kodekonveyor.repo.backend.api.LerpoiEntityRepositoryStubs;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("lookup repository by name")
@TestedService("LookupRepositoryByNameService")
public class LookupRepositoryByNameServiceLookupRepositoryByNameTest
    extends LookupRepositoryByNameServiceTestBase {

  @Test
  @DisplayName(
    "looks up the sumti which is a repository, with the lerpoi given"
  )
  void test() {
    LerpoiEntityRepositoryStubs.behaviour(lerpoiEntityRepository);
    SumtiEntityRepositoryStubs.behaviour(sumtiEntityRepository);
    assertEquals(
        SumtiDTOTestData.get(),
        lookupRepoByNameService.call(LerpoiTestData.TEXT)
    );
  }

  @Test
  @DisplayName(
    "UUID of the Sumti is returned successfully"
  )
  void test1() {
    LerpoiEntityRepositoryStubs.behaviour(lerpoiEntityRepository);
    SumtiEntityRepositoryStubs.behaviour(sumtiEntityRepository);
    assertEquals(
        SumtiDTOTestData.get().getUuid(),
        lookupRepoByNameService.call(LerpoiTestData.TEXT).getUuid()
    );
  }

  @Test
  @DisplayName(
    "Lerpoi ID of the Sumti is returned successfully"
  )
  void test2() {
    LerpoiEntityRepositoryStubs.behaviour(lerpoiEntityRepository);
    SumtiEntityRepositoryStubs.behaviour(sumtiEntityRepository);
    assertEquals(
        SumtiDTOTestData.get().getLerpoi(),
        lookupRepoByNameService.call(LerpoiTestData.TEXT).getLerpoi()
    );
  }

  @Test
  @DisplayName(
    "Bridi ID of the Sumti is returned successfully"
  )
  void test3() {
    LerpoiEntityRepositoryStubs.behaviour(lerpoiEntityRepository);
    SumtiEntityRepositoryStubs.behaviour(sumtiEntityRepository);
    assertEquals(
        SumtiDTOTestData.get().getBridi(),
        lookupRepoByNameService.call(LerpoiTestData.TEXT).getBridi()
    );
  }

  @Test
  @DisplayName(
    "if sumti for given lerpoi does not exist in repository, we throw an exception"
  )
  void test4() {
    LerpoiEntityRepositoryStubs.behaviour(lerpoiEntityRepository);
    SumtiEntityRepositoryStubs.sumtiNotExists(sumtiEntityRepository);
    ThrowableTester
        .assertThrows(() -> lookupRepoByNameService.call(LerpoiTestData.TEXT))
        .assertMessageIs(LookupRepoByNmaeTestData.NOT_FOUND_EXCEPTION);

  }

}
