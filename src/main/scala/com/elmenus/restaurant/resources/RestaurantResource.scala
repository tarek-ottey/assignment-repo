package com.elmenus.restaurant.resources

import akka.http.scaladsl.server.Route
import com.elmenus.restaurant.model.Restaurant
import com.elmenus.restaurant.routing.MyResource
import com.elmenus.restaurant.service.RestaurantService

/**
  * Given the provided `JSON` object, implement an HTTP service in Scala that will:
  * -Return the full object as a response to a `GET` request to `http://localhost:4000/api/restaurant`
  *
  * -Return **only open** restaurants as a response a `GET` request to `http://localhost:4000/api/restaurant?closed=0`
  *
  * -Append a new restaurant to the array provided in a response to a `POST` request to
  * `http://localhost:4000/api/restaurant` with a body similar to the restaurant structure provided.
  *
  * Your service should indicate the success or failure of the operation with relevant `HTTP` status codes
  * and subsequent `GET` requests should be able to include the appended restaurant
  *
  * -Change a restaurant data when a `PUT` request is
  * provided on `http://localhost:4000/api/restaurant/{uuid}` where `uuid` is the restaurant `uuid` and the body
  * of the request must match the restaurant structure. Your service should indicate the success or
  * failure of the operation with relevant `HTTP` status codes and subsequent `GET` requests should be able to include
  * the changed restaurant data
  */

trait RestaurantResource extends MyResource {

  val restaurantService: RestaurantService

  def restaurantRoutes: Route = pathPrefix("api") {
    pathPrefix("restaurant") {
      pathEnd {
      post {
        entity(as[Restaurant]) { restaurant =>
          completeWithLocationHeader(
            resourceId = restaurantService.createRestaurant(restaurant),
            ifDefinedStatus = 201, ifEmptyStatus = 409)
        }
        }
      }~
      get{
        parameter("closed"?) { query =>
          if(query.isEmpty)
            complete(restaurantService.getAllRestaurants())
          else
           complete(restaurantService.getRestaurantsByClosedFlag(query.get))
        }
      }
      }~
      path(Segment) { uuid =>
        put {
          entity(as[Restaurant]) { restaurant =>
            complete(restaurantService.updateRestaurant(uuid, restaurant))
          }
       }
      }
  }


}
