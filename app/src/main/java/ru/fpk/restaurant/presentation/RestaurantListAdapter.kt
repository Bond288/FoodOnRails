package ru.fpk.restaurant.presentation

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.fpk.R
import ru.fpk.restaurant.data.Restaurant
import javax.inject.Inject

class RestaurantListAdapter @Inject constructor(private val context: Context) :
    RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>(){

    private val restaurantList = mutableListOf<Restaurant>()

    fun setRestaurantList(restaurantList: List<Restaurant>) {
        this.restaurantList.clear()
        this.restaurantList.addAll(restaurantList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val restaurantView = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_card, parent, false)
        return RestaurantViewHolder(restaurantView)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurantList[position]

        val restaurantImageUrl = restaurant.image
        Glide
            .with(context)
            .load(restaurantImageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.backgroundImage!!)

        holder.restaurantRating?.text = restaurant.rating.rating.toString()
        holder.restaurantName?.text = restaurant.name
        holder.deliveryTime?.text = restaurant.timeOfPreparing.toString()
        val categories = restaurant.categories
        val kitchenList = ""
        categories.forEach { kitchenList + it.name +", "}
        Log.d("ttt", "kitchenList = $kitchenList")
        holder.kitchenList?.text = kitchenList
    }

    class RestaurantViewHolder(restaurantView: View?) : RecyclerView.ViewHolder(restaurantView!!) {
        var backgroundImage: ImageView? = null
        var restaurantRating: TextView? = null
        var restaurantName: TextView? = null
        var deliveryTime: TextView? = null
        var kitchenList: TextView? = null

        init {
            backgroundImage = restaurantView?.findViewById(R.id.background_image)
            restaurantRating = restaurantView?.findViewById(R.id.restaurant_rating)
            restaurantName = restaurantView?.findViewById(R.id.restaurant_name)
            deliveryTime = restaurantView?.findViewById(R.id.delivery_time)
            kitchenList = restaurantView?.findViewById(R.id.kitchen_list)
        }
    }
}