package ru.fpk

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.fpk.di.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> = DaggerAppComponent.builder().build()
}