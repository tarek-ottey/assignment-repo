package com.elmenus.restaurant.model

/**
  * @author Riham Fayez
  * @since  20/10/17.
  */
case class Data(enName:String, arName:String, state:String, routingMethod:Option[String], logo:Option[String],
                coverPhoto:Option[String],
                enDescription:Option[String], arDescription:Option[String], shortNumber:Option[String],
                facebookLink:Option[String], twitterLink:Option[String], youtubeLink:Option[String],
                website:Option[String], onlinePayment:Boolean, client:Boolean, pendingInfo:Boolean,
                pendingMenu:Boolean, closed:Boolean)
