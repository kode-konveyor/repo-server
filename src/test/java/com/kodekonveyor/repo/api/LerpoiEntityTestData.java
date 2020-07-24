package com.kodekonveyor.repo.api;

public class LerpoiEntityTestData {

  public static LerpoiEntity get() {
    final LerpoiEntity lerpoi = new LerpoiEntity();
    lerpoi.setName(LerpoiTestData.NAME);
    lerpoi.setDescription(LerpoiTestData.DESCRIPTION);
    lerpoi.setId(LerpoiTestData.ID);
    return lerpoi;
  }

}
