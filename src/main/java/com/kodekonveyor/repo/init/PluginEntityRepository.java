package com.kodekonveyor.repo.init;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PluginEntityRepository
    extends PagingAndSortingRepository<PluginEntity, Long> {

}
