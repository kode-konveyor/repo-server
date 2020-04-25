package com.kodekonveyor.repo.api;

import lombok.Data;

@Data
class ElementModificationDTO {

  private ElementDTO newElement;

  private ElementDTO oldElement;


}
