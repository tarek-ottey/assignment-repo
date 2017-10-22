package com.elmenus.restaurant

import scala.concurrent.ExecutionContext
import akka.http.scaladsl.server.Route
import com.elmenus.restaurant.resources.RestaurantResource
import com.elmenus.restaurant.service.RestaurantService


/**
  * @author Riham Fayez
  * @since  21/10/17.
  */
trait RestInterface extends Resources {

  implicit def executionContext: ExecutionContext

  lazy val restaurantService = new RestaurantService

  val routes: Route = restaurantRoutes

}

trait Resources extends RestaurantResource

