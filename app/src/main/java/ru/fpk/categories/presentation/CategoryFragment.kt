package ru.fpk.categories.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.fpk.R
import ru.fpk.categories.data.Category
import ru.fpk.mvvm.getViewModel
import toothpick.Toothpick

class CategoryFragment : Fragment() {
    private var adapter: CategoryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val scope = Toothpick.openScopes(this.activity!!.application, this.activity, this)
        adapter = scope.getInstance(CategoryAdapter::class.java)
        val viewModel = getViewModel(scope, CategoryViewModel::class.java)
        val restaurantList = view.findViewById<RecyclerView>(R.id.restaurant_list)
        restaurantList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        restaurantList.adapter = adapter
        viewModel.categories().observe(this, Observer { set(it) })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_list, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toothpick.closeScope(this)
    }

    private fun set(categories: List<Category>){
        adapter?.set(categories)
    }
}