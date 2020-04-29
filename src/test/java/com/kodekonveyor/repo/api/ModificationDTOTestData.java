package com.kodekonveyor.repo.api;

import java.util.Set;

public class ModificationDTOTestData {

  public static ModificationDTO get() {
    final ModificationDTO modificationDTO = new ModificationDTO();
    modificationDTO.setCreated(Set.of(ElementDTOTestData.get()));
    modificationDTO.setDeleted(Set.of());
    modificationDTO.setModified(Set.of());
    return modificationDTO;
  }
  public static ModificationDTO getWithWrongSyntax() {
    final ElementModificationDTO elementModificationDTO = new ElementModificationDTO();
    elementModificationDTO.setNewElement(ElementDTOTestData.getWithWrongSyntax());
    elementModificationDTO.setOldElement(ElementDTOTestData.get());
    final ModificationDTO modificationDTO = get();
    modificationDTO.setModified(Set.of(elementModificationDTO));
    return modificationDTO;
  }
  public static ModificationDTO getFoundServer() {
    final ModificationDTO modificationDTO = get();
    modificationDTO.setCreated(Set.of(ElementDTOTestData.getFoundServer()));
    return modificationDTO;
  }
  public static ModificationDTO getRemote() {
    final ModificationDTO modificationDTO = get();
    modificationDTO.setCreated(Set.of(ElementDTOTestData.getRemote()));
    return modificationDTO;
  }
  public static ModificationDTO getNotFoundLocal() {
    final ModificationDTO modificationDTO = get();
    modificationDTO.setCreated(Set.of(ElementDTOTestData.getNotFoundLocal()));
    return modificationDTO;
  }
  public static ModificationDTO getNotFoundServer() {
    final ModificationDTO modificationDTO = get();
    modificationDTO.setCreated(Set.of(ElementDTOTestData.getNotFoundServer()));
    return modificationDTO;
  }
}
