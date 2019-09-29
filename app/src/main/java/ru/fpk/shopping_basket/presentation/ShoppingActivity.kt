package ru.fpk.shopping_basket.presentation

import android.os.Bundle
import android.text.Html
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.fpk.R
import ru.fpk.meal.data.Meal
import ru.fpk.mvvm.getViewModel
import toothpick.Toothpick

class ShoppingActivity : AppCompatActivity() {
    private var adapter: ShopptingAdapter? = null
    private var summTextView: TextView? = null
    private var emptyTextView: TextView? = null
    private var payedButton: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scope = Toothpick.openScopes(application, this)
        setContentView(R.layout.shopping_activity)
        val listContentView = findViewById<RecyclerView>(R.id.selected_mills)
        summTextView = findViewById(R.id.sum)
        payedButton = findViewById(R.id.buy_button)
        emptyTextView = findViewById(R.id.text_empty)
        adapter = scope.getInstance(ShopptingAdapter::class.java)
        listContentView.adapter = adapter
        val itemTouchHelper = ItemTouchHelper(SwipeDeleteCallback(adapter))
        itemTouchHelper.attachToRecyclerView(listContentView)
        val viewModel = getViewModel(scope, ShoppingViewModel::class.java)
        viewModel.list().observe(this, Observer { change(it) })
        viewModel.price().observe(this, Observer { changePrice(it) })
        payedButton?.setOnClickListener { viewModel.payed() }
    }

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(this)
    }

    private fun changePrice(price: Double?) {
        price?.let {
            summTextView?.text = Html.fromHtml("<b>Сумма:</b> $price &#8381;")
        }
    }

    private fun change(meals: List<Meal>?) {
        meals?.let {
            adapter?.set(it)
            emptyTextView?.visibility = if (it.isEmpty()) {
                VISIBLE
            } else {
                GONE
            }
        }
    }
}
