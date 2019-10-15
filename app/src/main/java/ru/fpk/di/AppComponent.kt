package ru.fpk.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.fpk.App
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<App> {

    override fun inject(app: App)

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}