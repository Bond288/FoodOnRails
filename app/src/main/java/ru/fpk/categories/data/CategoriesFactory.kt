package ru.fpk.categories.data

import javax.inject.Inject

class CategoriesFactory @Inject constructor() {

    fun categories() = listOf(
        Category("Все", "all", ""),
        Category("Восточная", "asia", ""),
        Category("Мексиканская", "mehico", ""),
        Category("Русская", "russia", ""),
        Category("Итальянская", "italian", ""),
        Category("Американская", "american", "")
    )
}