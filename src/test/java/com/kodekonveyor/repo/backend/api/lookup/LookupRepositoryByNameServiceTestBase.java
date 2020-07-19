package com.kodekonveyor.repo.backend.api.lookup;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.repo.api.LerpoiEntityRepository;
import com.kodekonveyor.repo.api.SumtiEntityRepository;

public class LookupRepositoryByNameServiceTestBase {

  @Mock
  LerpoiEntityRepository lerpoiEntityRepository;
  @InjectMocks
  protected LookupRepositoryByNameService lookupRepoByNameService;
  @Mock
  SumtiEntityRepository sumtiEntityRepository;

}
