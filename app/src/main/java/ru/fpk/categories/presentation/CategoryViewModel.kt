package ru.fpk.categories.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.fpk.categories.data.CategoriesProvider
import ru.fpk.categories.data.Category
import ru.fpk.mvvm.RxViewModel
import javax.inject.Inject

class CategoryViewModel @Inject constructor(categoriesProvider: CategoriesProvider): RxViewModel() {
    private val categories = MutableLiveData<List<Category>>()
    init {
        add(categoriesProvider.categories()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                categories.value = it
            },{

            }))
    }

    fun categories(): LiveData<List<Category>> = categories
}