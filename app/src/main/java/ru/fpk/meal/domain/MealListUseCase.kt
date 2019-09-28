package ru.fpk.meal.domain

import io.reactivex.Single
import ru.fpk.meal.data.Meal
import ru.fpk.meal.data.MealsListProvider
import ru.fpk.restaurant.data.Restaurant
import javax.inject.Inject

class MealListUseCase @Inject constructor(private val provider: MealsListProvider) {

    fun loadMealList(restaurant: Restaurant): Single<List<Meal>> =
        provider.mealList(restaurant)
}
