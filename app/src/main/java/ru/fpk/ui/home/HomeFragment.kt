package ru.fpk.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import ru.fpk.R
import ru.fpk.mvvm.getViewModel
import toothpick.Toothpick

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val scope = Toothpick.openScopes(this.activity!!.application, this.activity, this)
        homeViewModel = getViewModel(scope, HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner = view.findViewById<Spinner>(R.id.stations_spinner)

        homeViewModel.stations().observe(this, Observer {
            val arrayNamesStation = it.toTypedArray()
            context?.let {
                val adapter = CustomArrayAdapter(it, arrayNamesStation)
                spinner.adapter = adapter
            }
        })
    }
}