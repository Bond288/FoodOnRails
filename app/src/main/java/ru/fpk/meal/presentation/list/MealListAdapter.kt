package ru.fpk.meal.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.fpk.R
import ru.fpk.meal.data.Meal
import ru.fpk.meal.domain.MealSelect
import javax.inject.Inject

class MealListAdapter @Inject constructor(
    private val mealSelect: MealSelect
) : RecyclerView.Adapter<MealViewHolder>() {

    private val mealList = mutableListOf<Meal>()

    fun setMealList(mealList: List<Meal>) {
        this.mealList.clear()
        this.mealList.addAll(mealList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = mealList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val mealView =
            LayoutInflater.from(parent.context).inflate(R.layout.meal_card, parent, false)
        return MealViewHolder(mealView)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = mealList[position]
        holder.set(meal)
        holder.itemView.setOnClickListener { mealSelect.click(meal) }
    }

    override fun onViewRecycled(holder: MealViewHolder) {
        holder.clear()
    }
}