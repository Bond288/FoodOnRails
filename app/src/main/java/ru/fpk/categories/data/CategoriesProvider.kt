package ru.fpk.categories.data

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CategoriesProvider @Inject constructor(categoriesFactory: CategoriesFactory){
    private val catigories = categoriesFactory.categories()

    fun categories(): Single<List<Category>> {
        return Single.just(catigories)
            .subscribeOn(Schedulers.io())
    }
}