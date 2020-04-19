package com.kodekonveyor.init;

import java.util.List;

public class PluginEntityTestData {

  public static final String SERVICE_NAME = "MetaModelCheckService";
  public static Object SERVICE_OBJECT;

  public static PluginEntity get() {

    final PluginEntity pluginEntity = new PluginEntity();
    pluginEntity.setMetamodelCheckServiceName(SERVICE_NAME);
    return pluginEntity;
  }

  public static Iterable<PluginEntity> list() {
    return List.of(get());
  }

}
