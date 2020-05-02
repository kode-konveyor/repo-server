package com.kodekonveyor.repo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.webapp.UrlMapConstants;

@RestController
public class ModifyElementController {

  @Autowired
  LookupDeletedAndModifiedElementsService lookupDeletedAndModifiedElementsService;

  @PostMapping(UrlMapConstants.MODIFY_ELEMENTS_PATH)
  public ModificationDTO call(final ModificationDTO modificationDTO) {
    lookupDeletedAndModifiedElementsService.call(modificationDTO);
    return null;
  }

}
