package com.kodekonveyor.repo.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.authentication.UserEntityRepositoryStubs;

class ModifyElementControllerTestBase {

  @Mock
  AuthenticatedUserService authenticatedUserService;
  @InjectMocks
  ModifyElementController modifyelementController;
  @Mock
  UserEntityRepository userEntityRepository;

  @BeforeEach

  void setUp() throws Exception {

    UserEntityRepositoryStubs.behaviour(userEntityRepository);

    //AuthenticatedUserStubs.behaviour(authenticatedUserService);
  }

}
