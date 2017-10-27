package com.rebiekong.wp.fc.message.output

import com.rebiekong.wp.fc.XmlUtils

import scala.collection.mutable


class BasicOutput(val toUser: String, val fromUser: String) {

  val data: mutable.ListBuffer[(String, Any)] = new mutable.ListBuffer[(String, Any)]

  override def toString: String = {
    this.toText.toString
  }

  def toText: TextOutput = new TextOutput(toUser, fromUser)

  def toImage: ImageOutput = new ImageOutput(toUser, fromUser)

  def toVoice: VoiceOutput = new VoiceOutput(toUser, fromUser)

  def toVideo: VideoOutput = new VideoOutput(toUser, fromUser)

  def toMusic: MusicOutput = new MusicOutput(toUser, fromUser)

  def toArticle: ArticleOutput = new ArticleOutput(toUser, fromUser)


  final def response: String = {
    data.append(("ToUserName", toUser))
    data.append(("FromUserName", fromUser))
    data.append(("CreateTime", (System.currentTimeMillis() / 1000).toInt))
    XmlUtils.parseXml("xml", data)
  }

}
