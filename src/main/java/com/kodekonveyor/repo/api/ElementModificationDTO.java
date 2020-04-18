package com.kodekonveyor.repo.api;

import lombok.Data;

@Data
public class ElementModificationDTO {

  private ElementDTO newElement;

  private ElementDTO oldElement;

}
