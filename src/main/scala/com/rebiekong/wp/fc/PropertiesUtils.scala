package com.rebiekong.wp.fc

import java.util.Properties

object PropertiesUtils {

  def getProperties(path: String): Properties = {

    val properties = new Properties()
    properties.load(PropertiesUtils.this.getClass.getResourceAsStream(path))
    properties
  }
}
