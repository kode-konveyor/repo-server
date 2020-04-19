package com.kodekonveyor.repo.api;

import org.springframework.beans.factory.annotation.Autowired;

public class CreateElementService {

  @Autowired
  private ElementEntityRepository elementEntityRepository;
  /*@Autowired
  private RepositoryEntityRepository repositoryEntityRepository;*/

  public ElementEntity call(final ElementDTO elementDTO) {
    final ElementEntity elementEntity = new ElementEntity();
    elementEntity.setCommit(elementDTO.getCommit());
    elementEntity.setDescription(elementDTO.getDescription());
    elementEntity.setName(elementDTO.getName());
    elementEntity.setSourceId(elementDTO.getSourceId());
    elementEntity.setTargetId(elementDTO.getTargetId());
    elementEntity.setId(elementDTO.getId());
    /*final RepositoryEntity entity =
      repositoryEntityRepository.findByOwner(elementEntity).get(0);
    elementEntityRepository.save(elementEntity);
    elementEntity.setRepo(entity);*/
    elementEntityRepository.save(elementEntity);

    return elementEntity;
  }
}
