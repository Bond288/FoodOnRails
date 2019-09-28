package ru.fpk.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import toothpick.Scope

class DependencyInjectionFactory internal constructor(private val scope: Scope) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return scope.getInstance(modelClass)
    }
}
