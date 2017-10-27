package com.rebiekong.wp.fc.message.input

class LinkInput(protected val xml: String) extends BasicInput(xml) {
  override val TYPE = "text"
  protected lazy val Title: String = getStringValue("Title")
  protected lazy val Description: String = getStringValue("Description")
  protected lazy val Url: String = getStringValue("Url")

  def getTitle: String = Title

  def getDescription: String = Description

  def getUrl: String = Url
}
