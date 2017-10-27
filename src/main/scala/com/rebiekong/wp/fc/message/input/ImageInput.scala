package com.rebiekong.wp.fc.message.input

class ImageInput(protected val xml: String) extends BasicInput(xml) {

  protected lazy val PicUrl: String = getStringValue("PicUrl")
  override  val TYPE = "image"
  protected lazy val MediaId: String = getStringValue("MediaId")

  def getPicUrl: String = PicUrl

  def getMediaId: String = MediaId

}
