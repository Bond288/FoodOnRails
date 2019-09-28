package ru.fpk.mvvm

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

import toothpick.Scope

object ViewModels {

    operator fun <T : ViewModel> get(fragment: Fragment, scope: Scope, modelClass: Class<T>): T {
        return ViewModelProviders
            .of(fragment, DependencyInjectionFactory(scope))
            .get(modelClass)
    }

    operator fun <T : ViewModel> get(
        activity: FragmentActivity,
        scope: Scope,
        modelClass: Class<T>
    ): T {
        return ViewModelProviders
            .of(activity, DependencyInjectionFactory(scope))
            .get(modelClass)
    }
}
