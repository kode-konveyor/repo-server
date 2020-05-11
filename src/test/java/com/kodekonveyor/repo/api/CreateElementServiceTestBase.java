package com.kodekonveyor.repo.api;

import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CreateElementServiceTestBase {

  @InjectMocks
  CreateElementService createElementService;
  @Mock
  ElementEntityRepository elementEntityRepository;
  @Mock
  RepositoryEntityRepository repositoryEntityRepository;
}
