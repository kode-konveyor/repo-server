package com.kodekonveyor.repo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekonveyor.repo.api.ModificationDTO;

@Service
public class ConsistencyCheckService {

  @Autowired
  private GetServiceByNameService getServiceByNameService;

  @Autowired
  private PluginEntityRepository pluginEntityRepository;

  public void call(final ModificationDTO modificationDTO) {

    final Iterable<PluginEntity> pluginEntities =
        pluginEntityRepository.findAll();
    for (final PluginEntity pluginEntity : pluginEntities) {
      final String serviceName = pluginEntity.getConstraintCheckServiceName();
      final ConsistencyChecker service =
          (ConsistencyChecker) getServiceByNameService.call(serviceName);
      service.call(modificationDTO);
    }

  }

}
