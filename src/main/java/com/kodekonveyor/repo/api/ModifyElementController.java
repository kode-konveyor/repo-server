package com.kodekonveyor.repo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.repo.init.ConsistencyCheckService;

@RestController
public class ModifyElementController {

  @Autowired
  ConsistencyCheckService consistencyCheckService;

  @PostMapping("/repo/(repoName)")
  public void
      call(final ModificationDTO modificationDTO, final String repoName) {
    consistencyCheckService.call(modificationDTO);

  }

}
