package ru.fpk.restaurant.domain

import io.reactivex.Single
import ru.fpk.restaurant.data.Restaurant
import ru.fpk.restaurant.data.RestaurantsProvider
import javax.inject.Inject

class ReastaurantListUseCase @Inject constructor(private val provider: RestaurantsProvider) {

    fun loadRestaurantList() : Single<List<Restaurant>> = provider.restaurants()
}