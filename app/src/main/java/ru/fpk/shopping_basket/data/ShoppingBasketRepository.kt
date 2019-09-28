package ru.fpk.shopping_basket.data

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import ru.fpk.meal.data.Meal
import ru.fpk.rx.startIfEmpty

class ShoppingBasketRepository {
    private val mealList = mutableListOf<Meal>()
    private val mealListSubject = BehaviorSubject.create<List<Meal>>()

    fun add(meal: Meal){
        mealList.add(meal)
        reload()
    }

    fun remove(meal: Meal){
        mealList.remove(meal)
        reload()
    }

    fun clear(){
        mealList.clear()
        reload()
    }

    fun mealList() : Observable<List<Meal>> = mealListSubject
        .startIfEmpty(Single.just<List<Meal>>(mealList))

    private fun reload() {
        mealListSubject.onNext(mealList)
    }
}