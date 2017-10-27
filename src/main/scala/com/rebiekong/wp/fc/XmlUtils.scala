package com.rebiekong.wp.fc

import scala.collection.mutable

object XmlUtils {

  def getMap[A, B]: mutable.Map[A, B] = {
    new mutable.HashMap[A, B]()
  }

  def parseXml(root: String, data: mutable.ListBuffer[(String, Any)]): String = {
    val stringBuilder = new mutable.StringBuilder()
    stringBuilder.append("<%s>".format(root))
    data.foreach(entry => {
      entry._2 match {
        case stringToObject: mutable.ListBuffer[(String, Any)] =>
          stringBuilder.append(parseXml(entry._1, stringToObject))
        case _ =>
          stringBuilder.append("<%s><![CDATA[%s]]></%s>".format(entry._1, entry._2.toString, entry._1))
      }
    })
    stringBuilder.append("</%s>".format(root))
    stringBuilder.toString()
  }
}
