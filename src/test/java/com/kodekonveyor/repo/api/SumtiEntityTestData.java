package com.kodekonveyor.repo.api;

public class SumtiEntityTestData {

  public static SumtiEntity get() {
    final SumtiEntity sumtiEntity = new SumtiEntity();
    sumtiEntity.setUuid(SumtiTestData.UUID);
    sumtiEntity.setId(SumtiTestData.ID);
    sumtiEntity.setLerpoi(LerpoiEntityTestData.get());
    sumtiEntity.setBridi(BridiEntityTestData.get());
    return sumtiEntity;
  }

  public static SumtiEntity getReference() {
    final SumtiEntity sumtiEntity = new SumtiEntity();
    sumtiEntity.setId(SumtiTestData.ID_REF);
    sumtiEntity.setUuid(SumtiTestData.UUID);
    sumtiEntity.setLerpoi(LerpoiEntityTestData.get());

    return sumtiEntity;

  }

}
