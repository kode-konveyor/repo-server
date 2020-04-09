package com.kodekonveyor.repo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekonveyor.repo.RepositoryEntity;

@Service
public class ConsistencyCheckService {

  @Autowired
  private List<ConsistencyChecker> consistencyCheckServiceList;

  public void call(
      final ModificationDTO modificationDTO, final RepositoryEntity repository
  ) {
    consistencyCheckServiceList.forEach(
        consistencyCheckService -> consistencyCheckService
            .call(modificationDTO, repository)
    );
  }
}
