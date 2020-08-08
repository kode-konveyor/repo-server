package com.kodekonveyor.repo.api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SumtiEntityRepository
    extends CrudRepository<SumtiEntity, Long> {

  List<SumtiEntity> findByLerpoi(LerpoiEntity lerpoiEntity);

}
