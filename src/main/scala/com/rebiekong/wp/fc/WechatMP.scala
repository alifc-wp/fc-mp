package com.rebiekong.wp.fc

import com.rebiekong.aliyun.fc.api.support.APIGatewayInput
import com.rebiekong.wp.fc.message.input.BasicInput
import com.rebiekong.wx.mp.encrypt.support.WXBizMsgCrypt

object WechatMP {
  def getBasicInput(input: APIGatewayInput): BasicInput = {
    val nonce = input.getQueryParameters.get("nonce")
    val timestamp = input.getQueryParameters.get("timestamp")
    val msgSignature = input.getQueryParameters.get("msg_signature")
    BasicInput.parse(dec(nonce, timestamp, msgSignature, input.getBody))
  }

  def dec(nonce: String, timestamp: String, signature: String, dec: String): String = {
    val properties = PropertiesUtils.getProperties("/wechat.properties.tml")
    new WXBizMsgCrypt(
      properties.getProperty("token"),
      properties.getProperty("aesKey"),
      properties.getProperty("appId")
    ).decryptMsg(signature, timestamp, nonce, dec)
  }

  def main(args:Array[String]): Unit ={
    // demo
    val input:APIGatewayInput = _
    val op = getBasicInput(input).getOutput.toText
    op.content = "this is a demo"
    println(op.toString)
  }
}
