package ru.fpk.shopping_basket.presentation

import android.content.Intent
import android.os.Bundle
import android.text.Html.fromHtml
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.support.DaggerAppCompatActivity
import ru.fpk.R
import ru.fpk.meal.data.Meal
import ru.fpk.mvvm.DependencyInjectionFactory
import ru.fpk.mvvm.getViewModel
import javax.inject.Inject

class ShoppingActivity : DaggerAppCompatActivity() {

    companion object {
        private const val REQUEST_CODE = 100
    }

    @Inject
    lateinit var viewModelFactory: DependencyInjectionFactory
    @Inject lateinit var adapter: ShopptingAdapter
    private var summTextView: TextView? = null
    private var emptyTextView: TextView? = null
    private var payedButton: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_activity)
        val listContentView = findViewById<RecyclerView>(R.id.selected_mills)
        summTextView = findViewById(R.id.sum)
        payedButton = findViewById(R.id.buy_button)
        emptyTextView = findViewById(R.id.text_empty)
        listContentView.adapter = adapter
        val itemTouchHelper = ItemTouchHelper(SwipeDeleteCallback(adapter))
        itemTouchHelper.attachToRecyclerView(listContentView)
        val viewModel: ShoppingViewModel = getViewModel(viewModelFactory)
        viewModel.list().observe(this, Observer { change(it) })
        viewModel.price().observe(this, Observer { changePrice(it) })
        payedButton?.setOnClickListener {
            val intent = Intent(this, BankCardActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
            viewModel.payed()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            Toast.makeText(this, "Успешно оплачено", Toast.LENGTH_LONG).show()
        }
    }

    private fun changePrice(price: Double?) {
        price?.let {
            summTextView?.text = fromHtml("<b>Сумма:</b> $price &#8381;")
        }
    }

    private fun change(meals: List<Meal>?) {
        meals?.let {
            adapter.set(it)
            emptyTextView?.visibility = if (it.isEmpty()) {
                VISIBLE
            } else {
                GONE
            }
        }
    }
}
