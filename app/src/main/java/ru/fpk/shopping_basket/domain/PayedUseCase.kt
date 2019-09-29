package ru.fpk.shopping_basket.domain

import javax.inject.Inject

class PayedUseCase @Inject constructor(private val foodListEditorUseCase: FoodListEditorUseCase) {

    fun payed() {
        foodListEditorUseCase.clear()
    }
}