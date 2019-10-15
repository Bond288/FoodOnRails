package ru.fpk.meal.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.fpk.meal.data.Meal
import ru.fpk.meal.domain.MealListUseCase
import ru.fpk.mvvm.RxViewModel
import ru.fpk.restaurant.data.Restaurant
import ru.fpk.restaurant.domain.RestaurantClick
import javax.inject.Inject

class MealListViewModel @Inject constructor(
    mealUseCase: MealListUseCase,
    restaurantClick: RestaurantClick
) : RxViewModel() {

    private val mealListLiveData = MutableLiveData<List<Meal>>()
    private lateinit var selected: Restaurant

    init {
        add(restaurantClick
            .observe()
            .subscribe {selected = it}
        )

        add(
            mealUseCase.loadMealList(selected)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mealListLiveData.value = it
                },
                    {
                        mealListLiveData.value = emptyList()
                    })
        )
    }

    fun mealList(): LiveData<List<Meal>> = mealListLiveData

}