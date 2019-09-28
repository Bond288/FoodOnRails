package ru.fpk.di

import android.content.Context
import toothpick.config.Module

class BaseModule(context: Context) : Module() {

    init {
        bind(Context::class.java).toInstance(context)
    }
}