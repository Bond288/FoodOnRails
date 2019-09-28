package ru.fpk.shopping_basket.domain

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import ru.fpk.meal.data.Meal
import ru.fpk.shopping_basket.data.ShoppingBasketRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListMealUseCase @Inject constructor(private val repository: ShoppingBasketRepository) {

    fun dichesList(): Observable<List<Meal>> = repository.mealList()

    fun price(): Observable<Double> = repository.mealList()
        .map { calculatePrice(it) }

    private fun calculatePrice(mealList: List<Meal>): Double = mealList
        .map { it.price }
        .reduce { one, two -> one + two }
}