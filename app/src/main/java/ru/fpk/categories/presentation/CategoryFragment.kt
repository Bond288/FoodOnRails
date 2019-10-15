package ru.fpk.categories.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import ru.fpk.R
import ru.fpk.categories.data.Category
import ru.fpk.mvvm.DependencyInjectionFactory
import ru.fpk.mvvm.getViewModel
import javax.inject.Inject

class CategoryFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: DependencyInjectionFactory
    @Inject
    lateinit var adapter: CategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: CategoryViewModel = getViewModel(viewModelFactory)
        val restaurantList = view.findViewById<RecyclerView>(R.id.restaurant_list)
        restaurantList.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
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

    private fun set(categories: List<Category>) {
        adapter?.set(categories)
    }
}