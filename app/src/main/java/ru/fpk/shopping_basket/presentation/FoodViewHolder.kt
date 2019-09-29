package ru.fpk.shopping_basket.presentation

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.fpk.R
import ru.fpk.meal.data.Meal

class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val image = view.findViewById<ImageView>(R.id.image)
    private val title = view.findViewById<TextView>(R.id.title)
    private val price = view.findViewById<TextView>(R.id.price)

    fun set(meal: Meal) {
        title.text = meal.name
        price.text = Html.fromHtml("${meal.price} &#8381;")
        Glide.with(itemView)
            .load(meal.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(image)
    }


}