package com.elmenus.restaurant.service

import com.elmenus.restaurant.integration.RestaurantFile
import com.elmenus.restaurant.model.Restaurant

import scala.concurrent.{ExecutionContext, Future}

/**
  * @author Riham Fayez
  * @since  20/10/17.
  */

class RestaurantService(implicit val executionContext: ExecutionContext) {

  var loadedRestaurants = RestaurantFile.loadFileContent();

  /**
    * Create a new restaurant if uuid is not already matching with an existing restaurant in the list
    * @param restaurant new restaurant to add to the list
    * @return uuid of created restaurant
    */
  def createRestaurant(restaurant: Restaurant):Future[Option[String]] =  Future {
    loadedRestaurants.find(_.uuid == restaurant.uuid) match {
      case Some(q) => None // Conflict! id is already taken
      case None =>
        loadedRestaurants = loadedRestaurants :+ restaurant
        Some(restaurant.uuid)
    }

  }

  /**
    * Delete an existing Restaurant by uuid
    * @param uuid unique identifier of the restaurant
    */
  def deleteRestaurant(uuid: String)=  Future {
    loadedRestaurants = loadedRestaurants.filterNot(_.uuid == uuid)
  }

  /**
    * Get all restaurants in the system
    * @return
    */
  def getAllRestaurants(): Future[List[Restaurant]] =  Future {
    loadedRestaurants
  }

  /**
    * Get restaurants based on the closed flag
    * @param closed if value 0 then return opened otherwise return closed restaurants
    * @return list of the restaurants  that match criteria
    */
  def getRestaurantsByClosedFlag(closed:String):  Future[List[Restaurant]] =  Future {
    loadedRestaurants.filter (_.data.closed== !(closed.equals("0")))
  }

  /**
    * get restaurant by uuid
    * @param uuid unique identifier of the restaurant
    * @return restaurant if the uuid exist
    */
  def getRestaurant(uuid: String): Future[Option[Restaurant]] =  Future {
    loadedRestaurants.find(_.uuid== uuid)
  }

  /**
    * Update restaurant that match specified uuid
    * @param uuid unique identifier of the restaurant
    * @param restaurant restaurant to update existing restaurant
    * @return updated restaurant
    */
  def updateRestaurant(uuid: String, restaurant: Restaurant):Future[Option[Restaurant]]=  Future {
    loadedRestaurants.find(_.uuid == restaurant.uuid) match {
      case Some(q) =>
            //Delete restaurant
             deleteRestaurant(uuid)
            //create new updated one
            createRestaurant(restaurant)
             //load updated restaurant
            loadedRestaurants.find(_.uuid== uuid)
      case None =>None
      }
  }



}
