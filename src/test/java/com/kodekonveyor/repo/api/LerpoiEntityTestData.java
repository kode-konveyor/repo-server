package com.kodekonveyor.repo.api;

public class LerpoiEntityTestData {

  public static LerpoiEntity get() {
    final LerpoiEntity lerpoi = new LerpoiEntity();
    lerpoi.setText(LerpoiTestData.NAME);
    lerpoi.setDescription(LerpoiTestData.DESCRIPTION);
    lerpoi.setId(LerpoiTestData.ID);
    return lerpoi;
  }

}
