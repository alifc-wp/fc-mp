package com.rebiekong.wp.fc.message.output

import scala.collection.mutable

class VideoOutput(override val toUser: String, override val fromUser: String) extends BasicOutput(toUser, fromUser) {

  var videoItem: VideoItem = _

  override def toString: String = {
    data.append(("MsgType", "voice"))
    val video = new mutable.ListBuffer[(String, Any)]
    video.append(("MediaId", videoItem.mediaId))
    video.append(("Title", videoItem.title))
    video.append(("Description", videoItem.description))
    data.append(("Video", video))
    response
  }

  case class VideoItem(mediaId: String,
                       title: String,
                       description: String)


}
