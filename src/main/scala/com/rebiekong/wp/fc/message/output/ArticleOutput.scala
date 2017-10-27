package com.rebiekong.wp.fc.message.output

import scala.collection.mutable

class ArticleOutput(override val toUser: String, override val fromUser: String) extends BasicOutput(toUser, fromUser) {

  var articles: mutable.HashSet[ArticleItem] = new mutable.HashSet[ArticleItem]()

  override def toString: String = {
    data.append(("MsgType", "news"))
    data.append(("ArticleCount", articles.size))
    val articleList = new mutable.ListBuffer[(String, Any)]
    articles.foreach(article => {
      val oh = new mutable.ListBuffer[(String, String)]
      oh.append(("Title", article.title))
      oh.append(("Description", article.description))
      oh.append(("PicUrl", article.picUrl))
      oh.append(("Url", article.url))
      articleList.append(("item", oh))
    })
    data.append(("Articles", articleList))
    response
  }

  case class ArticleItem(
                          title: String,
                          description: String,
                          picUrl: String,
                          url: String
                        )

}
