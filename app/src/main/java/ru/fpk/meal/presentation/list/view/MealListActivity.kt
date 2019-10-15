package ru.fpk.meal.presentation.list.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.fpk.R
import ru.fpk.di.BaseModule
import ru.fpk.meal.presentation.list.MealListAdapter
import ru.fpk.meal.presentation.list.MealListViewModel
import ru.fpk.mvvm.getViewModel
import ru.fpk.shopping_basket.presentation.ShoppingActivity
import toothpick.Toothpick
import java.util.concurrent.TimeUnit
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
        val restaurantCardView = findViewById<CardView>(R.id.restaurant_card)
        val restaurantBackgroundGradient = findViewById<ImageView>(R.id.background_gradient)
        val restaurantImage = findViewById<ImageView>(R.id.background_image)
        val restaurantName = findViewById<TextView>(R.id.restaurant_name)
        val restaurantRating = findViewById<TextView>(R.id.restaurant_rating)
        val deliveryTime = findViewById<TextView>(R.id.delivery_time)
        val restaurantCategories = findViewById<TextView>(R.id.kitchen_list)

        restaurantCardView.radius = 0f

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            restaurantBackgroundGradient.background = ContextCompat.getDrawable(this, R.drawable.background_image_gradient)
        }

        restaurantName.text = intent.extras.getString("restaurant_name")
        restaurantRating.text = intent.extras.getDouble("restaurant_rating").toString()

        val restaurantImageUrl = intent.extras.getString("restaurant_image_url")
        Glide
            .with(this)
            .load(restaurantImageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(restaurantImage)

        val timeUnit = TimeUnit.MINUTES.convert(intent.extras.getLong("restaurant_delivery_time"), TimeUnit.MILLISECONDS)
        deliveryTime.text = timeUnit.toString() + " мин."
        restaurantCategories.text = intent.extras.getString("restaurant_categories")

        mealList.layoutManager = LinearLayoutManager(this)
        mealList.adapter = adapter

        viewModel.mealList().observe(this, Observer {
            adapter.setMealList(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.meal_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.buy -> showBuy()
            else -> false
        }
    }

    private fun showBuy(): Boolean {
        val intent = Intent(this, ShoppingActivity::class.java)
        startActivity(intent)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(this)
    }
}
