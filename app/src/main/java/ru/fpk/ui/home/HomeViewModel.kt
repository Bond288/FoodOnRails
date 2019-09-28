package ru.fpk.ui.home

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.fpk.categories.data.Category
import ru.fpk.meal.presentation.MealListActivity
import ru.fpk.mvvm.RxViewModel
import ru.fpk.restaurant.data.Restaurant
import ru.fpk.restaurant.domain.RestaurantClick
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val context: Context,
    restaurantClick: RestaurantClick
) : RxViewModel() {

    init {
        add(restaurantClick.observe().subscribe(
            {
                Log.d("ttt", "restaurantClick = ")

                startRestaurantActivity(context, it)
            },
            {}
        ))
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private fun startRestaurantActivity(context: Context, restaurant: Restaurant) {
        val intent = Intent(context, MealListActivity::class.java)
        intent.putExtra("restaurant_name", restaurant.name)
        intent.putExtra("restaurant_rating", restaurant.rating.rating)
        intent.putExtra("restaurant_image_url", restaurant.image)
        intent.putExtra("restaurant_delivery_time", restaurant.timeOfPreparing)
        intent.putExtra("restaurant_categories", categoryList(restaurant.categories))

        context.startActivity(intent)
    }

    private fun categoryList(categories: List<Category>): String {
        return categories.joinToString {it.name}
    }
}