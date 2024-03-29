package ru.fpk.restaurant.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.fpk.mvvm.RxViewModel
import ru.fpk.restaurant.data.Restaurant
import ru.fpk.restaurant.domain.RestaurantListUseCase
import javax.inject.Inject

class RestaurantListViewModel @Inject constructor(restaurantUseCase: RestaurantListUseCase) : RxViewModel() {
    private val restaurantListLiveData = MutableLiveData<List<Restaurant>>()

    init {
        add(
            restaurantUseCase.loadRestaurantList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    restaurantListLiveData.value = it
                },
                    {})
        )
    }

    fun restaurantList(): LiveData<List<Restaurant>> = restaurantListLiveData

}