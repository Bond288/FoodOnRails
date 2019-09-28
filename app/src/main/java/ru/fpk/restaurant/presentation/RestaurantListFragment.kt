package ru.fpk.restaurant.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.fpk.R
import ru.fpk.mvvm.getViewModel
import toothpick.Toothpick

class RestaurantListFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val scope = Toothpick.openScopes(this.activity!!.application, this.activity, this)
        val adapter = scope.getInstance(RestaurantListAdapter::class.java)
        val viewModel = getViewModel(scope, RestaurantListViewModel::class.java)
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
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_list, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toothpick.closeScope(this)
    }
}