package com.rebiekong.wp.fc.message.input

import java.io.StringReader

import com.rebiekong.wp.fc.message.output.BasicOutput
import org.dom4j.io.SAXReader

class BasicInput(private val xml: String) {
  val TYPE = "basic"

  protected lazy val ToUserName: String = getStringValue("ToUserName")
  protected lazy val FromUserName: String = getStringValue("FromUserName")
  protected lazy val CreateTime: Int = getIntValue("CreateTime")
  protected lazy val MsgType: String = getStringValue("MsgType")
  protected lazy val MsgId: String = getStringValue("MsgId")

  private lazy val rootElement = new SAXReader().read(new StringReader(xml)).getRootElement

  def getToUserName: String = ToUserName

  def getFromUserName: String = FromUserName

  def getCreateTime: Int = CreateTime

  def getMsgType: String = MsgType

  def getMsgId: String = MsgId

  protected def getStringValue(key: String): String = rootElement.element(key).getText

  protected def getIntValue(key: String): Int = rootElement.element(key).getText.toInt

  def toText: TextInput = new TextInput(xml)

  def toImage: ImageInput = new ImageInput(xml)

  def toLink: LinkInput = new LinkInput(xml)

  def toLocation: LocationInput = new LocationInput(xml)

  def toVideo: VideoInput = new VideoInput(xml)

  def toShortVideo: ShortVideoInput = new ShortVideoInput(xml)

  def toVoice: VoiceInput = new VoiceInput(xml)

  protected def toRealInput: BasicInput = {
    getMsgType match {
      case "text" => toText
      case "image" => toImage
      case "voice" => toVoice
      case "video" => toVideo
      case "shortvideo" => toShortVideo
      case "link" => toLink
      case "location" => toLocation
      case _ => this
    }
  }


  def getOutput: BasicOutput = {
    new BasicOutput(FromUserName, ToUserName)
  }
}

object BasicInput {

  def parse(xml: String): BasicInput = {
    new BasicInput(xml).toRealInput
  }

}