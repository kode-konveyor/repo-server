package com.kodekonveyor.repo.api;

import java.util.Set;

public class ModificationDTOTestData {

  public static ModificationDTO get() {

    return createModificationDTO(Set.of(ElementDTOTestData.get()),Set.of(),Set.of());
  }

  private static ModificationDTO createModificationDTO(final Set<ElementDTO> created, final Set<ElementDTO> deleted, final Set<ElementModificationDTO> modified) {
    final ModificationDTO modificationDTO = new ModificationDTO();

    modificationDTO.setCreated(created);
    modificationDTO.setDeleted(deleted);
    modificationDTO.setModified(modified);

    return modificationDTO;
  }

  public static ModificationDTO getWithWrongSyntax() {

    return createModificationDTO(Set.of(),Set.of(ElementDTOTestData.getWithWrongSyntax()),Set.of());
  }

  public static ModificationDTO getFoundServer() {

    return createModificationDTO(Set.of(ElementDTOTestData.getFoundServer()),Set.of(),Set.of());
  }

  public static ModificationDTO getRemote() {

    return createModificationDTO(Set.of(ElementDTOTestData.getRemote()),Set.of(),Set.of());
  }

  public static ModificationDTO getNotFoundLocal() {

    return createModificationDTO(Set.of(),Set.of(ElementDTOTestData.getNotFoundLocal()),Set.of());
  }

  public static ModificationDTO getNotFoundServer() {

    return createModificationDTO(Set.of(),Set.of(ElementDTOTestData.getNotFoundServer()),Set.of());
  }


}
