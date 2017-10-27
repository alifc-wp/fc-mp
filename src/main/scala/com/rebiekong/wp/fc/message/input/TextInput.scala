package com.rebiekong.wp.fc.message.input

class TextInput(protected val xml: String) extends BasicInput(xml) {
  override val TYPE = "text"
  protected lazy val Content: String = getStringValue("Content")

  def getContent: String = Content
}
