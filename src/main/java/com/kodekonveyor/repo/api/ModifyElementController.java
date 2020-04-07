package com.kodekonveyor.repo.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyElementController {

  public static final String MARK_AS_PAID_PATH = "/paid/{workRequestId}";

  public static final String MARK_AS_PAID_WORK_REQUEST_ID = "workRequestId";

  ModificationDTO modification;

  @PutMapping(MARK_AS_PAID_PATH)
  public ModificationDTO
      call(@PathVariable(MARK_AS_PAID_WORK_REQUEST_ID) final long workRequestId, @RequestBody final ModificationDTO modification) {

    return modification;

  }

}
