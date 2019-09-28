package ru.fpk.categories.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.fpk.R
import ru.fpk.categories.data.Category
import ru.fpk.categories.domain.SelectCategoryStorage
import javax.inject.Inject

class CategoryAdapter @Inject constructor(private val selectCategoryStorage: SelectCategoryStorage) :
    RecyclerView.Adapter<CategoryViewHolder>() {
    private val categories = mutableListOf<Category>()

    fun set(categories: List<Category>) {
        this.categories.clear()
        this.categories.addAll(categories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.set(category)
        holder.itemView.setOnClickListener { selectCategoryStorage.changeCategory(category) }
    }

    override fun getItemCount(): Int = categories.size
}