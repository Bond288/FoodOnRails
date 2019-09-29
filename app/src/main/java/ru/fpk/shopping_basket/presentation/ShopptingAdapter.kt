package ru.fpk.shopping_basket.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.fpk.R
import ru.fpk.meal.data.Meal
import ru.fpk.shopping_basket.domain.FoodListEditorUseCase
import javax.inject.Inject

class ShopptingAdapter @Inject constructor(private val foodListEditorUseCase: FoodListEditorUseCase) :
    RecyclerView.Adapter<FoodViewHolder>() {
    private val selectedFood = mutableListOf<Meal>()

    fun set(meals: List<Meal>) {
        selectedFood.clear()
        selectedFood.addAll(meals)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val meal = selectedFood[position]
        holder.set(meal)
        holder.itemView.setOnClickListener {}
    }

    override fun getItemCount(): Int = selectedFood.size

    fun remove(position: Int) {
        val meal = selectedFood[position]
        foodListEditorUseCase.remove(meal)
    }
}
