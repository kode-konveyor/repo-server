package com.kodekonveyor.repo.api;

import java.util.Set;

public class ModificationDTOTestData {

  public static ModificationDTO get() {
    // TODO Auto-generated method stub
    final ModificationDTO modificationDTO = new ModificationDTO();
    modificationDTO.setCreated(Set.of(ElementDTOTestData.get()));
    return null;
  }

}
