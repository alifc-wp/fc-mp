package com.rebiekong.wp.fc.message.output

class TextOutput(override val toUser: String, override val fromUser: String) extends BasicOutput(toUser, fromUser) {

  var content: String = "hello"

  override def toString: String = {
    data.append(("MsgType", "text"))
    data.append(("content", content))
    response
  }

}
