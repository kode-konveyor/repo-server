package com.kodekonveyor.repo.api;

import java.util.List;

public class BridiEntityTestData {

  public static BridiEntity get() {
    final BridiEntity bridi = new BridiEntity();
    bridi.setId(BridiTestData.ID);
    bridi.setSelbri(SumtiEntityTestData.getReference());
    bridi.setSumti(List.of(SumtiEntityTestData.getReference()));
    return bridi;
  }

}
