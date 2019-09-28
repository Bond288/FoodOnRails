package ru.fpk.meal.domain

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import ru.fpk.meal.data.Meal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealClick @Inject constructor(){

    private val click: BehaviorSubject<Meal> = BehaviorSubject.create()

    fun click(restaurantClicked: Meal) {
        click.onNext(restaurantClicked)
    }

    fun observe(): Observable<Meal> {
        return click
    }
}