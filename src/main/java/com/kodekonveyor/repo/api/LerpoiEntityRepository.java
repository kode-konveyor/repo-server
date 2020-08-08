package com.kodekonveyor.repo.api;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface LerpoiEntityRepository
    extends CrudRepository<LerpoiEntity, Long> {

  Optional<LerpoiEntity> findByName(String repoName);

}
