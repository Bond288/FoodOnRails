package ru.fpk.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import ru.fpk.R

class DiscountsFragment : DaggerFragment() {

    private lateinit var discountsViewModel: DiscountsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        discountsViewModel =
            ViewModelProviders.of(this).get(DiscountsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        discountsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}