package ru.fpk.restaurant.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import ru.fpk.R
import ru.fpk.mvvm.DependencyInjectionFactory
import ru.fpk.mvvm.getViewModel
import javax.inject.Inject

class RestaurantListFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: DependencyInjectionFactory
    @Inject
    lateinit var adapter: RestaurantListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel:RestaurantListViewModel = getViewModel(viewModelFactory)
        val restaurantList = view.findViewById<RecyclerView>(R.id.restaurant_list)
        restaurantList.layoutManager = LinearLayoutManager(activity)
        restaurantList.adapter = adapter
        viewModel.restaurantList().observe(this, Observer {
            adapter.setRestaurantList(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_restaurant_list, container, false)
}