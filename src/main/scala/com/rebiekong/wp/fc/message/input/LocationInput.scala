package com.rebiekong.wp.fc.message.input

class LocationInput(protected val xml: String) extends BasicInput(xml) {
  override  val TYPE = "text"

  protected lazy val Location_X: String = getStringValue("Location_X")
  protected lazy val Location_Y: String = getStringValue("Location_Y")
  protected lazy val Scale: String = getStringValue("Scale")
  protected lazy val Label: String = getStringValue("Label")

  def getLocationX: String = Location_X

  def getLocationY: String = Location_Y

  def getScale: String = Scale

  def getLabel: String = Label
}
