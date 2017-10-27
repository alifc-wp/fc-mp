package com.rebiekong.wp.fc.message.output

import scala.collection.mutable

class MusicOutput(override val toUser: String, override val fromUser: String) extends BasicOutput(toUser, fromUser) {

  var musicItem: MusicItem = _


  override def toString: String = {
    data.append(("MsgType", "voice"))
    val music = new mutable.ListBuffer[(String, Any)]
    music.append(("MediaId", musicItem.mediaId))
    music.append(("Title", musicItem.title))
    music.append(("Description", musicItem.description))
    music.append(("MusicUrl", musicItem.musicUrl))
    music.append(("HQMusicUrl", musicItem.hQMusicUrl))
    music.append(("ThumbMediaId", musicItem.thumbMediaId))
    data.append(("Music", music))
    response
  }

  case class MusicItem(mediaId: String,
                       title: String,
                       description: String,
                       musicUrl: String,
                       hQMusicUrl: String,
                       thumbMediaId: String)

}
