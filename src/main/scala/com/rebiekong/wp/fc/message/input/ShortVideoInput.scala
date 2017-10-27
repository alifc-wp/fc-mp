package com.rebiekong.wp.fc.message.input

class ShortVideoInput(protected val xml: String) extends BasicInput(xml) {
  override  val TYPE = "shortvideo"

  protected lazy val MediaId: String = getStringValue("MediaId")
  protected lazy val ThumbMediaId: String = getStringValue("ThumbMediaId")

  def getThumbMediaId: String = ThumbMediaId

  def getMediaId: String = MediaId

}
