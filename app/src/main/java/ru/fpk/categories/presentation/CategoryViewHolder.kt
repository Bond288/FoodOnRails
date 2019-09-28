package ru.fpk.categories.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.fpk.R
import ru.fpk.categories.data.Category

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val textView: TextView = view.findViewById(R.id.category_name)

    fun set(category: Category) {
        textView.text = category.name
    }
}