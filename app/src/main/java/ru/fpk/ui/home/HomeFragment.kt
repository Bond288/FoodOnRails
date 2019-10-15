package ru.fpk.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.lifecycle.Observer
import dagger.android.support.DaggerFragment
import ru.fpk.R
import ru.fpk.mvvm.DependencyInjectionFactory
import ru.fpk.mvvm.getViewModel
import javax.inject.Inject

class HomeFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: DependencyInjectionFactory
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = getViewModel(viewModelFactory)
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