package ru.fpk.di

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity
import ru.fpk.meal.presentation.MealListActivity
import ru.fpk.shopping_basket.presentation.BankCardActivity
import ru.fpk.shopping_basket.presentation.ShoppingActivity

@Module
interface ContextModule {

    @Binds
    fun context(activity: Activity): Context
}