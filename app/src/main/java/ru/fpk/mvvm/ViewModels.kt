package ru.fpk.mvvm

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> Fragment.getViewModel(
    factory: ViewModelProvider.Factory
): T {
    return ViewModelProviders
        .of(this, factory)
        .get(T::class.java)
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(
    factory: ViewModelProvider.Factory
): T {
    return ViewModelProviders
        .of(this, factory)
        .get(T::class.java)
}
