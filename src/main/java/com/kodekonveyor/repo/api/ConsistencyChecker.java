package com.kodekonveyor.repo.api;

import org.springframework.stereotype.Service;

import com.kodekonveyor.repo.RepositoryEntity;

@Service
public interface ConsistencyChecker {

  void call(
      final ModificationDTO modificationDTO,
      final RepositoryEntity repositoryEntity
  );
}
