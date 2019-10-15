package ru.fpk.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.fpk.MainActivity
import ru.fpk.meal.presentation.MealListActivity
import ru.fpk.shopping_basket.presentation.BankCardActivity
import ru.fpk.shopping_basket.presentation.ShoppingActivity

@Module(includes = [AndroidSupportInjectionModule::class])
interface AppModule {

    @ContributesAndroidInjector(modules = [ContextModule::class])
    fun mainActivity() : MainActivity

    @ContributesAndroidInjector(modules = [ContextModule::class])
    fun shoppingActivity() : ShoppingActivity

    @ContributesAndroidInjector(modules = [ContextModule::class])
    fun mealListActivity() : MealListActivity

    @ContributesAndroidInjector(modules = [ContextModule::class])
    fun bankCardActivity() : BankCardActivity
}