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

public class ModifyElementControllerElementValidationTest extends ModifyElementControllerTestBase {
  @Test
  @DisplayName("found local should be accepted")
  public void test1() {
    ThrowableTester.assertNoException(()->modifyElementController.call(ModificationDTOTestData.get(),RepositoryEntityTestData.FOUND_LOCAL_REPO_NAME,RepositoryEntityTestData.FOUND_LOCAL_TAG_NAME));
  }
  @Test
  @DisplayName("syntax should not be accepted")
  public void test2() {
    ThrowableTester.assertThrows(()->modifyElementController.call(ModificationDTOTestData.getWithWrongSyntax(),RepositoryEntityTestData.SYNTAX_REPO_NAME,RepositoryEntityTestData.SYNTAX_TAG_NAME)).assertException(ConstraintException.class);
  }
  @Test
  @DisplayName("found server should be accepted")
  public void test3() {
    ThrowableTester.assertNoException(()->modifyElementController.call(ModificationDTOTestData.getFoundServer(),RepositoryEntityTestData.FOUND_SERVER_REPO_NAME,RepositoryEntityTestData.FOUND_SERVER_TAG_NAME));
  }
  @Test
  @DisplayName("remote should be accepted")
  public void test4() {
    ThrowableTester.assertNoException(()->modifyElementController.call(ModificationDTOTestData.getRemote(),RepositoryEntityTestData.REMOTE_REPO_NAME,RepositoryEntityTestData.REMOTE_TAG_NAME));
  }
  @Test
  @DisplayName("not found local should not be accepted")
  public void test5() {
    ThrowableTester.assertThrows(()->modifyElementController.call(ModificationDTOTestData.getNotFoundLocal(),RepositoryEntityTestData.NOT_FOUND_LOCAL_REPO_NAME,RepositoryEntityTestData.NOT_FOUND_LOCAL_TAG_NAME)).assertException(ConstraintException.class);
  }
  @Test
  @DisplayName("not found server should not be accepted")
  public void test6() {
    ThrowableTester.assertThrows(()->modifyElementController.call(ModificationDTOTestData.getNotFoundServer(),RepositoryEntityTestData.NOT_FOUND_SERVER_REPO_NAME,RepositoryEntityTestData.NOT_FOUND_SERVER_TAG_NAME)).assertException(ConstraintException.class);
  }
}
