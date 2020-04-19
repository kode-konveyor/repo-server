package com.kodekonveyor.repo.api;

import lombok.Data;

@Data
class ElementDTO {

  private String commit;

  private String description;

  private String id;

  private String name;

  private String sourceId;

  private String targetId;

}
