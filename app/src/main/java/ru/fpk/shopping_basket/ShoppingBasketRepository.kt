package ru.fpk.shopping_basket

import ru.fpk.meal.Meal

class ShoppingBasketRepository {
    private val mealList = mutableListOf<Meal>()

    fun add(meal: Meal){
        mealList.add(meal)
    }

    fun remove(meal: Meal){
        mealList.remove(meal)
    }

    fun clear(){
        mealList.clear()
    }

    fun mealList() : List<Meal> = mealList
}