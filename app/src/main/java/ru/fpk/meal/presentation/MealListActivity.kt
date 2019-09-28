package ru.fpk.meal.presentation

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.fpk.R
import ru.fpk.di.BaseModule
import ru.fpk.mvvm.getViewModel
import toothpick.Toothpick
import javax.inject.Inject

class MealListActivity @Inject constructor() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_list)
        val scope = Toothpick.openScopes(application, this)

        scope.installModules(BaseModule(this))

        val adapter = scope.getInstance(MealListAdapter::class.java)
        val viewModel = getViewModel(scope, MealListViewModel::class.java)
        val mealList = findViewById<RecyclerView>(R.id.meal_list)
        val restaurantName = findViewById<TextView>(R.id.restaurant_name)
        val restaurantRating = findViewById<TextView>(R.id.restaurant_rating)
        val restaurantImage = findViewById<ImageView>(R.id.background_image)
        val deliveryTime = findViewById<TextView>(R.id.delivery_time)
        val restaurantCategories = findViewById<TextView>(R.id.kitchen_list)

        restaurantName.text = intent.extras.getString("restaurant_name")
        restaurantRating.text = intent.extras.getDouble("restaurant_rating").toString()

        val restaurantImageUrl = intent.extras.getString("restaurant_image_url")
        Glide
            .with(this)
            .load(restaurantImageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(restaurantImage)

        deliveryTime.text = intent.extras.getLong("restaurant_delivery_time").toString()
        restaurantCategories.text = intent.extras.getString("restaurant_categories")

        mealList.layoutManager = LinearLayoutManager(this)
        mealList.adapter = adapter

        viewModel.mealList().observe(this, Observer {
            adapter.setMealList(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(this)
    }
}
