package com.kodekonveyor.repo.api;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyElementController {


  @Autowired
  private ElementRepository elementRepository;

  @Autowired
  private CheckReferenceService checkReferenceService;

  @PutMapping("/repo/{repoName}/{tagName}")
  public ModificationDTO call(@RequestBody final ModificationDTO modification,@PathVariable("repoName")final String repoName ,@PathVariable("tagName")
  final String tagName) {

    final Set<ElementDTO> elements = new HashSet<>() ;
    elements.addAll(modification.getCreated());
    elements.addAll(modification.getDeleted());
    modification.getModified().forEach((modified)->addModificationToSet(modified,elements));

    final Stream<Optional<ElementEntity>> elementEntities = elements.stream().map(element->elementRepository.findById(element.getId()));
    elementEntities.forEach(entity -> checkReferences(entity));

    return null;

  }

  private void checkReferences(final Optional<ElementEntity> entity) {
    final ElementEntity elementEntity = entity.get();
    final CheckReferenceResultEnum sourceReference = checkReferenceService.call(elementEntity, elementEntity.getSource());
    final CheckReferenceResultEnum targetReference = checkReferenceService.call(elementEntity, elementEntity.getTarget());


    if(CheckReferenceResultEnum.SYNTAX.equals(sourceReference) || CheckReferenceResultEnum.SYNTAX.equals(targetReference))
      throw new ConstraintException();

    if(CheckReferenceResultEnum.NOT_FOUND_LOCAL.equals(sourceReference) || CheckReferenceResultEnum.NOT_FOUND_LOCAL.equals(targetReference))
      throw new ConstraintException();

    if(CheckReferenceResultEnum.NOT_FOUND_SERVER.equals(sourceReference) || CheckReferenceResultEnum.NOT_FOUND_SERVER.equals(targetReference))
      throw new ConstraintException();

  }

  private void addModificationToSet(
      final ElementModificationDTO modified, final Set<ElementDTO> elements ) {
    elements.addAll(Set.of(modified.getNewElement(), modified.getOldElement()));

  }

}
