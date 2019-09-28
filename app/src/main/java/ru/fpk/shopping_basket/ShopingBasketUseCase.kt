package ru.fpk.shopping_basket

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import ru.fpk.meal.Meal
import javax.inject.Inject

class ShopingBasketUseCase @Inject constructor(private val repository: ShoppingBasketRepository) {
    private val dishesSubject = BehaviorSubject.create<List<Meal>>()

    fun dichesList(): Observable<List<Meal>> = Observable.just(repository.mealList())

    fun price(): Observable<Double> = Observable.just(repository.mealList()
        .map { it.price }
        .reduce { one, two -> one + two })
}