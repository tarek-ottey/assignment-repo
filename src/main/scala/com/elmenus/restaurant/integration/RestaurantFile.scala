package com.elmenus.restaurant.integration


import com.elmenus.restaurant.model.{Data, Restaurant}
import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._
import play.api.libs.json.{JsPath, Json, Reads}

import scala.io.Source

/**
  * Load files of restaurants as a source for data in the application
  *
  * @author Riham Fayez
  * @since  21/10/17.
  */
object RestaurantFile {



  def loadFileContent():List[Restaurant]={

      implicit val dataReads: Reads[Data] = (
          (JsPath \ "enName").read[String]  and
          (JsPath \ "arName").read[String]  and
          (JsPath \ "state").read[String]   and
          (JsPath \ "routingMethod").readNullable[String] and
          (JsPath \ "logo").readNullable[String]  and
          (JsPath \ "coverPhoto").readNullable[String]  and
          (JsPath \ "enDescription").readNullable[String]  and
          (JsPath \ "arDescription").readNullable[String]  and
          (JsPath \ "shortNumber").readNullable[String]  and
          (JsPath \ "facebookLink").readNullable[String]  and
          (JsPath \ "twitterLink").readNullable[String]  and
          (JsPath \ "youtubeLink").readNullable[String]  and
          (JsPath \ "website").readNullable[String]  and
          (JsPath \ "onlinePayment").read[Boolean]  and
          (JsPath \ "client").read[Boolean]  and
          (JsPath \ "pendingInfo").read[Boolean] and
          (JsPath \ "pendingMenu").read[Boolean] and
          (JsPath \ "closed").read[Boolean]

        )(Data.apply _)

      implicit val restaurantReads:Reads[Restaurant] = (
        (JsPath \ "uuid").read[String]
         and
         (JsPath \ "data").read[Data]
        )(Restaurant.apply _)
      val json = Json.parse(Source.fromURL(Source.getClass().getResource("/sample-restaurant-data.json"))
        .getLines().mkString)


      json.as[List[Restaurant]]
  }
}
