package com.kodekonveyor.repo.api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RepositoryEntityRepository
    extends CrudRepository<RepositoryEntity, Long> {

  //List<RepositoryEntity> findByName(ElementEntity elementEntity);

  List<RepositoryEntity> findByName(String repoName);

  List<RepositoryEntity> findByOwner(ElementEntity elementEntity);

}
