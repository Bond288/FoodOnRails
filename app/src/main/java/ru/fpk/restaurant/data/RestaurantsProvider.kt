package ru.fpk.restaurant.data

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RestaurantsProvider @Inject constructor(private val restaurantFactory: RestaurantFactory){

    fun restaurants() = Single.just(restaurantFactory.raestaurantList())
        .subscribeOn(Schedulers.io())
}