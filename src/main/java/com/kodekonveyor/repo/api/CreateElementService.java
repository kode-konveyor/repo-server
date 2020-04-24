package com.kodekonveyor.repo.api;

import org.springframework.beans.factory.annotation.Autowired;

public class CreateElementService {

  @Autowired
  private ElementEntityRepository elementEntityRepository;

  public void call(
      final ElementDTO elementDTO, final RepositoryEntity repositoryEntity
  ) {
    final ElementEntity elementEntity = new ElementEntity();
    elementEntity.setCommit(elementDTO.getCommit());
    elementEntity.setDescription(elementDTO.getDescription());
    elementEntity.setName(elementDTO.getName());
    elementEntity.setSourceId(elementDTO.getSourceId());
    elementEntity.setTargetId(elementDTO.getTargetId());
    elementEntity.setId(elementDTO.getId());
    elementEntity.setSourceTag(elementDTO.getSourceTag());
    elementEntity.setTargetTag(elementDTO.getTargetTag());
    /*elementEntity.setRepo(repositoryEntity);*/
    elementEntityRepository.save(elementEntity);

  }
}
