package ru.fpk.shopping_basket.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ru.fpk.R
import ru.fpk.meal.data.Meal
import ru.fpk.mvvm.getViewModel
import toothpick.Toothpick

class ShoppingActivity : AppCompatActivity() {
    private var adapter: ShopptingAdapter? = null
    private var summTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scope = Toothpick.openScopes(application, this)
        setContentView(R.layout.shopping_activity)
        val listContentView = findViewById<RecyclerView>(R.id.selected_mills)
        adapter = scope.getInstance(ShopptingAdapter::class.java)
        listContentView.adapter = adapter
        val itemTouchHelper = ItemTouchHelper(SwipeDeleteCallback(adapter))
        itemTouchHelper.attachToRecyclerView(listContentView)
        val viewModel = getViewModel(scope, ShoppingViewModel::class.java)
        viewModel.list().observe(this, Observer { change(it) })
        viewModel.price().observe(this, Observer { changePrice(it) })
    }

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(this)
    }

    private fun changePrice(price: Double?) {
        price?.let {
            summTextView?.text = String.format("%.2f", it)
        }
    }

    private fun change(meals: List<Meal>?) {
        meals?.let {
            adapter?.set(it)
        }
    }
}
