package ru.fpk.meal.presentation

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.fpk.R
import ru.fpk.meal.data.Meal
import ru.fpk.meal.domain.MealClick
import ru.fpk.shopping_basket.data.ShoppingBasketRepository
import javax.inject.Inject

class MealListAdapter @Inject constructor(
    private val context: Context,
    private val shoppingRepository: ShoppingBasketRepository
) :
    RecyclerView.Adapter<MealListAdapter.MealViewHolder>() {

    private val mealList = mutableListOf<Meal>()

    fun setMealList(mealList: List<Meal>) {
        this.mealList.clear()
        this.mealList.addAll(mealList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val mealView =
            LayoutInflater.from(parent.context).inflate(R.layout.meal_card, parent, false)
        return MealViewHolder(mealView)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = mealList[position]

        holder.itemView.setOnClickListener { MealClick().click(meal) }
        val mealImageUrl = meal.imageUrl
        Glide
            .with(context)
            .load(mealImageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.backgroundImage!!)

        holder.mealName?.text = meal.name
        holder.ingredients?.text = ingredients(meal.ingredients)
        holder.price?.text = Html.fromHtml("${meal.price} &#8381;")
        holder.buyButton?.setOnClickListener {
            if(holder.buyButton?.isSelected == true){
                holder.buyButton?.isSelected = false
                shoppingRepository.remove(meal)
            } else {
                holder.buyButton?.isSelected = true
                shoppingRepository.add(meal)
            }
        }
    }

    private fun ingredients(ingredients: List<String>): String {
        return ingredients.joinToString { it }
    }

    class MealViewHolder(mealView: View?) : RecyclerView.ViewHolder(mealView!!) {
        var backgroundImage: ImageView? = null
        var mealName: TextView? = null
        var ingredients: TextView? = null
        var price: TextView? = null
        var buyButton: ImageButton? = null

        init {
            backgroundImage = mealView?.findViewById(R.id.meal_background_image)
            mealName = mealView?.findViewById(R.id.meal_name)
            ingredients = mealView?.findViewById(R.id.meal_ingradients)
            price = mealView?.findViewById(R.id.meal_price)
            buyButton = mealView?.findViewById(R.id.buy_button)
        }
    }
}