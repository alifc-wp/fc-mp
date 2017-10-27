package com.rebiekong.wp.fc.message.output

import scala.collection.mutable

class ImageOutput(override val toUser: String, override val fromUser: String) extends BasicOutput(toUser, fromUser) {

  var imageItem: ImageItem = _

  override def toString: String = {
    data.append(("MsgType", "image"))
    val image = new mutable.ListBuffer[(String, String)]
    image.append(("MediaId", imageItem.mediaId))
    data.append(("Image", image))
    response
  }

  case class ImageItem(mediaId: String)

}


