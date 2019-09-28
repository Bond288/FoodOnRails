package ru.fpk.categories.data

class CategoriesFactory {

    fun categories() = listOf(
        Category("Все", "all", ""),
        Category("Восточная", "asia", ""),
        Category("Мексиканская", "mehico", ""),
        Category("Русская", "russia", ""),
        Category("Итальянская", "italian", ""),
        Category("Американская", "american", "")
    )
}