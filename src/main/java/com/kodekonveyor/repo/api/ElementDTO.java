package com.kodekonveyor.repo.api;

import lombok.Data;

@Data
public class ElementDTO {

  private String commit;

  private String description;

  private String id;

  private String name;

  private String source;

  private String target;

}
