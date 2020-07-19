package com.kodekonveyor.repo.api;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface SumtiEntityRepository
    extends CrudRepository<SumtiEntity, Long> {

  Optional<SumtiEntity> findByLerpoi(LerpoiEntity lerpoiEntity);

}
