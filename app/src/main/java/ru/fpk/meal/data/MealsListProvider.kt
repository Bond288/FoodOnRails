package ru.fpk.meal.data

import ru.fpk.restaurant.data.Restaurant
import javax.inject.Inject

class MealsListProvider @Inject constructor(private val factory: MealsListFactory) {

    fun mealList(restaurant: Restaurant) = factory.mealsList(restaurant)
}