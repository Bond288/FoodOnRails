package ru.fpk.shopping_basket.domain

import ru.fpk.meal.data.Meal
import ru.fpk.shopping_basket.data.ShoppingBasketRepository
import javax.inject.Inject

class FoodListEditorUseCase @Inject constructor(private val repository: ShoppingBasketRepository) {

    fun add(meal: Meal) {
        repository.add(meal)
    }

    fun remove(meal: Meal) {
        repository.remove(meal)
    }

    fun clear() {
        repository.clear()
    }
}