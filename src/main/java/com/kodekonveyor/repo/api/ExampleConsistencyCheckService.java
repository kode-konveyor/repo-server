package com.kodekonveyor.repo.api;

import org.springframework.stereotype.Service;

import com.kodekonveyor.repo.RepositoryEntity;

@Service
public class ExampleConsistencyCheckService implements ConsistencyChecker {

  @Override
  public void
      call(
          final ModificationDTO modificationDTO,
          final RepositoryEntity repositoryEntity
      ) {
    throw new RuntimeException();
  }

}
