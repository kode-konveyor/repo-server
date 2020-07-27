package com.kodekonveyor.repo.backend.api.lookup;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.repo.api.LerpoiEntityTag;
import com.kodekonveyor.repo.api.SumtiEntityTag;

public class LookupTagByNameServiceTestBase {

  @Mock
  LerpoiEntityTag lerpoiEntityTag;
  @InjectMocks
  protected LookupTagByNameService lookupTagByNameService;
  @Mock
  SumtiEntityTag sumtiEntityTag;
}
