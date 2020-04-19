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
    // RepositoryEntityStubs.behaviour(repositoryEntityRepository);
    createElementService.call(ElementDTOTestData.get());
    Mockito.verify(elementEntityRepository).save(ElementEntityTestData.get());

  }

  @Test
  @DisplayName("ElementEntity created is Empty")
  void testEmptyData() {
    Mockito.when(elementEntityRepository.save(ElementEntityTestData.get()))
        .thenReturn(new ElementEntity());
    assertNotNull(
        createElementService
            .call(new ElementDTO())
    );

  }

  @Test
  @DisplayName("ElementEntity's commit is not null")
  void testEntityCommit() {
    Mockito.when(elementEntityRepository.save(ElementEntityTestData.get()))
        .thenReturn(ElementEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getCommit(),
        createElementService.call(ElementDTOTestData.get()).getCommit()
    );

  }

  @Test
  @DisplayName("ElementEntity's description is created successfully")
  void testEntitydescription() {
    Mockito.when(elementEntityRepository.save(ElementEntityTestData.get()))
        .thenReturn(ElementEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getDescription(),
        createElementService.call(ElementDTOTestData.get()).getDescription()
    );

  }

  @Test
  @DisplayName("ElementEntity's name created is not null")
  void testEntityName() {
    Mockito.when(elementEntityRepository.save(ElementEntityTestData.get()))
        .thenReturn(ElementEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getName(),
        createElementService.call(ElementDTOTestData.get()).getName()
    );

  }

  @Test
  @DisplayName("ElementEntity's source Id id not null")
  void testEntitySourceId() {
    Mockito.when(elementEntityRepository.save(ElementEntityTestData.get()))
        .thenReturn(ElementEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getSourceId(),
        createElementService.call(ElementDTOTestData.get()).getSourceId()
    );

  }

  @Test
  @DisplayName("ElementEntity's TargetId is not null")
  void testEntityTargetId() {
    Mockito.when(elementEntityRepository.save(ElementEntityTestData.get()))
        .thenReturn(ElementEntityTestData.get());
    assertEquals(
        ElementEntityTestData.get().getTargetId(),
        createElementService.call(ElementDTOTestData.get()).getTargetId()
    );

  }

  @Test
  @DisplayName("ElementEntity's Id  is not null")
  void testId() {
    Mockito.when(elementEntityRepository.save(ElementEntityTestData.get()))
        .thenReturn(ElementEntityTestData.get());
    assertNotNull(
        createElementService.call(ElementDTOTestData.get()).getId()
    );

  }

  @Test
  @DisplayName("ElementEntity created is not null")
  void testNotNull() {
    Mockito.when(elementEntityRepository.save(ElementEntityTestData.get()))
        .thenReturn(ElementEntityTestData.get());
    assertNotNull(
        createElementService
            .call(ElementDTOTestData.get())
    );

  }
}
