package ru.fpk.restaurant.domain

import io.reactivex.Single
import ru.fpk.categories.data.Category
import ru.fpk.categories.domain.SelectCategoryStorage
import ru.fpk.restaurant.data.Restaurant
import ru.fpk.restaurant.data.RestaurantsProvider
import javax.inject.Inject

class RestaurantListUseCase @Inject constructor(
    private val provider: RestaurantsProvider,
    private val selectCategoryStorage: SelectCategoryStorage
) {

    fun loadRestaurantList() = selectCategoryStorage.selectCategory()
        .switchMapSingle { loadRestaurantList(it) }

    private fun loadRestaurantList(category: Category): Single<List<Restaurant>> =
        provider.restaurants()
            .map {
                when (category.tag) {
                    "all" -> it
                    else -> it.filter { restaurant -> restaurant.categories.any { restaurantCategory -> restaurantCategory == category } }
                }
            }
}