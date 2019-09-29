package ru.fpk.meal.data

import io.reactivex.Single
import ru.fpk.restaurant.data.Restaurant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealsListFactory @Inject constructor(){
    fun mealsList(restaurant: Restaurant): Single<List<Meal>>{
        return when(restaurant.name){
            "KFC" -> Single.just(
                listOf(
                    Meal(
                        "Ножки",
                        listOf("Курица", "Специи"),
                        "https://s82079.cdn.ngenix.net/eQJqAgBWWoSUiBf7oG3kkfvE.png?dw=230",
                        160.00
                        ),
                    Meal(
                        "Крылья",
                        listOf("Курица", "Специи"),
                        "https://s82079.cdn.ngenix.net/bBT3VJ5NNWmKzcdtJRUTKphs.png?dw=230",
                        120.00
                    ),
                    Meal(
                        "Филе",
                        listOf("Курица", "Специи"),
                        "https://s82079.cdn.ngenix.net/Kq1eF5NBj287FHbv4gQr8xkb.png?dw=230",
                       200.00
                    ),
                    Meal(
                        "Твистер",
                        listOf("Курица", "Овощи", "Специи"),
                        "https://s82079.cdn.ngenix.net/MYzJ4vRR5ZbBcbw7DZBvbkEN.png?dw=230",
                        150.00
                    )
                )
            )
            else -> Single.just(emptyList())
        }
    }
}