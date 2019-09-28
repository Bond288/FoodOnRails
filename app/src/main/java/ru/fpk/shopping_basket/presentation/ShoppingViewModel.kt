package ru.fpk.shopping_basket.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.fpk.meal.data.Meal
import ru.fpk.mvvm.RxViewModel
import ru.fpk.shopping_basket.domain.FoodListEditorUseCase
import ru.fpk.shopping_basket.domain.ListMealUseCase
import javax.inject.Inject

class ShoppingViewModel @Inject constructor(
    listMealUseCase: ListMealUseCase,
    private val foodListEditorUseCase: FoodListEditorUseCase
) : RxViewModel() {
    private val mealList = MutableLiveData<List<Meal>>()
    private val price = MutableLiveData<Double>()

    init {
        add(listMealUseCase.dichesList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mealList.value = it
            }, {
                mealList.value = emptyList()
            })
        )
    }

    fun list() : LiveData<List<Meal>> = mealList

    fun price() : LiveData<Double> = price

    fun remove(meal: Meal){
        foodListEditorUseCase.remove(meal)
    }

    fun add(meal: Meal){
        foodListEditorUseCase.add(meal)
    }

    fun clearList(){
        foodListEditorUseCase.clear()
    }
}