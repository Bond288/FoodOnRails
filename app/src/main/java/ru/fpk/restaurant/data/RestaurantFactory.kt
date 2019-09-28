package ru.fpk.restaurant.data

import ru.fpk.categories.data.Category
import ru.fpk.popularity.Popularity

class RestaurantFactory {
    fun raestaurantList() = listOf(
        Restaurant(
            "KFC",
            "",
            Popularity(4.6, emptyList()),
            60 * 60 * 1000,
            listOf(Category("Американская", "american", ""))
        ),
        Restaurant(
            "Macdonalds",
            "",
            Popularity(4.6, emptyList()),
            60 * 60 * 1000,
            listOf(Category("Американская", "american", ""))
        ),
        Restaurant(
            "Dodo Pizza",
            "",
            Popularity(4.6, emptyList()),
            60 * 60 * 1000,
            listOf(Category("Итальянская", "italian", ""), Category("Американская", "american", ""))
        ),
        Restaurant(
            "harakiri",
            "",
            Popularity(4.6, emptyList()),
            60 * 60 * 1000,
            listOf(Category("Восточная", "asia", ""))
        ),
        Restaurant(
            "Элитный", "", Popularity(4.6, emptyList()), 60 * 60 * 1000, listOf(
                Category("Восточная", "asia", ""),
                Category("Мексиканская", "mehico", ""),
                Category("Русская", "russia", ""),
                Category("Итальянская", "italian", ""),
                Category("Американская", "american", "")
            )
        )
    )
}