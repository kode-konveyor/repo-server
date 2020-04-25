package com.kodekonveyor.repo.api;

import java.util.Set;

import lombok.Data;

@Data
class ElementWithRelationsDTO {

  private ElementDTO element;

  private Set<ElementDTO> sourceIn;

  private Set<ElementDTO> targetIn;


}
