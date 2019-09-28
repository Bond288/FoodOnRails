package ru.fpk.mvvm

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import toothpick.Scope

fun <T : ViewModel> Fragment.getViewModel(scope: Scope, modelClass: Class<T>): T {
        return ViewModelProviders
            .of(this, DependencyInjectionFactory(scope))
            .get(modelClass)
    }


fun <T : ViewModel> FragmentActivity.getViewModel(
        scope: Scope,
        modelClass: Class<T>
    ): T {
        return ViewModelProviders
            .of(this, DependencyInjectionFactory(scope))
            .get(modelClass)
    }
