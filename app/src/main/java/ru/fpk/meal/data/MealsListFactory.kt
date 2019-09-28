package ru.fpk.meal.data

import io.reactivex.Single
import ru.fpk.restaurant.data.Restaurant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealsListFactory @Inject constructor(){
    fun mealsList(restaurant: Restaurant): Single<List<Meal>>{
        return when(restaurant.name){
            else -> Single.just(emptyList())
        }
    }
}