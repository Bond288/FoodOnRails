package ru.fpk.restaurant.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.fpk.restaurant.data.Restaurant

class RestaurantListViewModel : ViewModel() {
    private val restaurantListLiveData = MutableLiveData<Restaurant>()
}