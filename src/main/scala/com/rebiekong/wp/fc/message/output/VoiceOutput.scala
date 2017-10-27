package com.rebiekong.wp.fc.message.output

import scala.collection.mutable

class VoiceOutput(override val toUser: String, override val fromUser: String) extends BasicOutput(toUser, fromUser) {

  var voiceItem: VoiceItem = _

  override def toString: String = {
    data.append(("MsgType", "voice"))
    val voice = new mutable.ListBuffer[(String,Any)]
    voice.append(("MediaId", voiceItem.mediaId))
    data.append(("Voice", voice))
    response
  }

  case class VoiceItem(mediaId: String)
}
