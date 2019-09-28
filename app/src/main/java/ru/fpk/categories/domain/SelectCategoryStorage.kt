package ru.fpk.categories.domain

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import ru.fpk.categories.data.Category
import javax.inject.Singleton

@Singleton
class SelectCategoryStorage {
    private val categorySubject = BehaviorSubject.create<Category>()

    fun selectCategory(): Observable<Category> = categorySubject.startWith(Category("Все", "all",""))

    fun changeCategory(category: Category){
        categorySubject.onNext(category)
    }
}