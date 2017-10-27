package com.rebiekong.wp.fc.message.input

class VideoInput(protected val xml: String) extends BasicInput(xml) {
  override  val TYPE = "video"

  protected lazy val MediaId: String = getStringValue("MediaId")
  protected lazy val ThumbMediaId: String = getStringValue("ThumbMediaId")

  def getThumbMediaId: String = ThumbMediaId

  def getMediaId: String = MediaId

}
