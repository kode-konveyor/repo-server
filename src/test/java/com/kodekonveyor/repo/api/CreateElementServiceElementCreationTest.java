package com.kodekonveyor.repo.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("element creation")
@TestedService("CreateElementService")
public class CreateElementServiceElementCreationTest
    extends CreateElementServiceTestBase {

  @Test
  @DisplayName("ElementEntity is created successfully")
  void test() {
    createElementService
        .call(ElementDTOTestData.get(), RepositoryEntityTestData.get());
    Mockito.verify(elementEntityRepository).save(ElementEntityTestData.get());

  }

  @Test
  @DisplayName("ElementEntity's commit is saved successfully")
  void testEntityCommit() {
    createElementService
        .call(ElementDTOTestData.get(), RepositoryEntityTestData.get());

    assertEquals(
        ElementEntityTestData.get().getCommit(),
        ElementDTOTestData.get().getCommit()
    );

  }

  @Test
  @DisplayName("ElementEntity's description is saved successfully")
  void testEntitydescription() {
    createElementService
        .call(ElementDTOTestData.get(), RepositoryEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getDescription(),
        ElementDTOTestData.get().getDescription()
    );

  }

  @Test
  @DisplayName("ElementEntity's name is saved successfully")
  void testEntityName() {
    createElementService
        .call(ElementDTOTestData.get(), RepositoryEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getName(),
        ElementDTOTestData.get().getName()
    );

  }

  @Test
  @DisplayName("ElementEntity's source Id is saved successfully")
  void testEntitySourceId() {
    createElementService
        .call(ElementDTOTestData.get(), RepositoryEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getSourceId(),
        ElementDTOTestData.get().getSourceId()
    );

  }

  @Test
  @DisplayName("ElementEntity's SourceTag is saved successfully")
  void testEntitySourceTag() {
    createElementService
        .call(ElementDTOTestData.get(), RepositoryEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getSourceTag(),
        ElementDTOTestData.get().getSourceTag()
    );

  }

  @Test
  @DisplayName("ElementEntity's TargetId is saved successfully")
  void testEntityTargetId() {
    createElementService
        .call(ElementDTOTestData.get(), RepositoryEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getTargetId(),
        ElementDTOTestData.get().getTargetId()
    );

  }

  @Test
  @DisplayName("ElementEntity's TargetTag is saved successfully")
  void testEntityTargetTag() {
    createElementService
        .call(ElementDTOTestData.get(), RepositoryEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getTargetTag(),
        ElementDTOTestData.get().getTargetTag()
    );

  }

  @Test
  @DisplayName("ElementEntity's Id  is saved successfully")
  void testId() {
    createElementService
        .call(ElementDTOTestData.get(), RepositoryEntityTestData.get());
    assertNotNull(
        ElementDTOTestData.get()
    );

  }

}
