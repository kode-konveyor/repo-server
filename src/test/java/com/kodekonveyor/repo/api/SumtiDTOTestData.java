package com.kodekonveyor.repo.api;

public class SumtiDTOTestData {

  public static SumtiDTO get() {
    final SumtiDTO sumtiDTO = new SumtiDTO();
    sumtiDTO.setUuid(SumtiTestData.UUID);
    sumtiDTO.setLerpoi(LerpoiEntityTestData.get().getId());
    sumtiDTO.setBridi(BridiEntityTestData.get().getId());
    return sumtiDTO;
  }

}
