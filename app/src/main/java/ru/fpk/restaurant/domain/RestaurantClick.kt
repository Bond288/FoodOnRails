package ru.fpk.restaurant.domain

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import ru.fpk.restaurant.data.Restaurant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestaurantClick @Inject constructor(){

    private val click: BehaviorSubject<Restaurant> = BehaviorSubject.create()

    fun click(restaurantClicked: Restaurant) {
        click.onNext(restaurantClicked)
    }

    fun observe(): Observable<Restaurant> {
        return click
    }
}