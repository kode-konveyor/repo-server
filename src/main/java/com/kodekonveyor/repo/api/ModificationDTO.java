package com.kodekonveyor.repo.api;

import java.util.Set;

import lombok.Data;

@Data
public class ModificationDTO {

  private Set<ElementDTO> created;

  private Set<ElementDTO> deleted;

  private Set<ElementModificationDTO> modified;

}
