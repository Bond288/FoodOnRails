package ru.fpk.meal.presentation.list

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.fpk.R
import ru.fpk.meal.data.Meal

class MealViewHolder(mealView: View?) : RecyclerView.ViewHolder(mealView!!) {
    private val backgroundImage: ImageView? = mealView?.findViewById(R.id.meal_background_image)
    private val mealName: TextView? = mealView?.findViewById(R.id.meal_name)
    private val ingredients: TextView? = mealView?.findViewById(R.id.meal_ingradients)
    private val price: TextView? = mealView?.findViewById(R.id.meal_price)

    fun set(meal: Meal) {
        backgroundImage?.let {
            Glide.with(itemView)
                .load(meal.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(it)
        }

        mealName?.text = meal.name
        ingredients?.text = meal.ingredients.joinToString { it }
        price?.text = Html.fromHtml("${meal.price} &#8381;")
    }

    fun clear() {
        backgroundImage?.let { Glide.with(itemView).clear(it) }
        mealName?.text = ""
        ingredients?.text = ""
        price?.text = ""
    }
}
