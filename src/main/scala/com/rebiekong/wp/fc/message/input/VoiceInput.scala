package com.rebiekong.wp.fc.message.input

class VoiceInput(protected val xml: String) extends BasicInput(xml) {
  override  val TYPE = "voice"

  protected lazy val Format: String = getStringValue("Format")

  protected lazy val MediaId: String = getStringValue("MediaId")
  protected lazy val Recognition: String = getStringValue("Recognition")

  def getFormat: String = Format

  def getMediaId: String = MediaId

  def getRecognition: String = Recognition

}
