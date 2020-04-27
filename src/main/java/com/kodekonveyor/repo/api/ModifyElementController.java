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

import com.kodekonveyor.webapp.UrlMapConstants;

@RestController
public class ModifyElementController {


  @Autowired
  ElementRepository elementRepository;

  @Autowired
  CheckReferenceService checkReferenceService;

  @PutMapping(UrlMapConstants.MODIFY_ELEMENT_PATH)
  public ModificationDTO call(@RequestBody final ModificationDTO modification,@PathVariable final String repoName ,@PathVariable final String tagName) {

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


    checkSyntax(sourceReference, targetReference);

    checkFoundLocal(sourceReference, targetReference);

    checkNotFoundServer(sourceReference, targetReference);

  }

  private void checkNotFoundServer(
      final CheckReferenceResultEnum sourceReference,
      final CheckReferenceResultEnum targetReference
      ) {
    if(CheckReferenceResultEnum.NOT_FOUND_SERVER.equals(sourceReference) || CheckReferenceResultEnum.NOT_FOUND_SERVER.equals(targetReference))
      throw new ConstraintException();
  }

  private void checkFoundLocal(
      final CheckReferenceResultEnum sourceReference,
      final CheckReferenceResultEnum targetReference
      ) {
    if(CheckReferenceResultEnum.NOT_FOUND_LOCAL.equals(sourceReference) || CheckReferenceResultEnum.NOT_FOUND_LOCAL.equals(targetReference))
      throw new ConstraintException();
  }

  private void checkSyntax(
      final CheckReferenceResultEnum sourceReference,
      final CheckReferenceResultEnum targetReference
      ) {
    if(CheckReferenceResultEnum.SYNTAX.equals(sourceReference) || CheckReferenceResultEnum.SYNTAX.equals(targetReference))
      throw new ConstraintException();
  }

  private void addModificationToSet(
      final ElementModificationDTO modified, final Set<ElementDTO> elements ) {
    elements.addAll(Set.of(modified.getNewElement(), modified.getOldElement()));

  }

}
