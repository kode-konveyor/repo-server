package com.kodekonveyor.repo.api;

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

@TestedBehaviour("metamodel checking")
@TestedService("MetamodelCheckService")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)


public class ModifyElementControllerElementValidationTest
extends ModifyElementControllerTestBase {

  @Test
  @DisplayName(value = "found local should be accepted")
  public void test1() {

    ThrowableTester.assertNoException(()->modifyElementController.call(ModificationDTOTestData.get(),"foundLocalRepoName","foundLocalTagName"));
  }
  @Test
  @DisplayName(value = "syntax should not be accepted")
  public void test2() {

    ThrowableTester.assertThrows(()->modifyElementController.call(ModificationDTOTestData.getWithWrongSyntax(),"syntaxRepoName","syntaxTagName")).assertException(ConstraintException.class);
  }

  @Test
  @DisplayName(value = "found server should be accepted")
  public void test3() {

    ThrowableTester.assertNoException(()->modifyElementController.call(ModificationDTOTestData.getFoundServer(),"foundServerRepoName","foundServerTagName"));
  }

  @Test
  @DisplayName(value = "remote should be accepted")
  public void test4() {

    ThrowableTester.assertNoException(()->modifyElementController.call(ModificationDTOTestData.getRemote(),"remoteRepoName","remoteTagName"));
  }

  @Test
  @DisplayName(value = "not found local should not be accepted")
  public void test5() {

    ThrowableTester.assertThrows(()->modifyElementController.call(ModificationDTOTestData.getNotFoundLocal(),"notFoundLocalRepoName","notFoundLocalTagName")).assertException(ConstraintException.class);
  }

  @Test
  @DisplayName(value = "not found server should not be accepted")
  public void test6() {

    ThrowableTester.assertThrows(()->modifyElementController.call(ModificationDTOTestData.getNotFoundServer(),"notFoundServerRepoName","notFoundServerTagName")).assertException(ConstraintException.class);

  }


}
