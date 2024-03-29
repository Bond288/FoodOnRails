package ru.fpk.restaurant.data

import ru.fpk.categories.data.Category
import ru.fpk.popularity.Popularity
import javax.inject.Inject

class RestaurantFactory @Inject constructor() {
    fun raestaurantList() = listOf(
        Restaurant(
            "KFC",
            "https://bipbap.ru/wp-content/uploads/2017/06/14813uxVsXjAPBFmIovEzZkHNnR.jpg",
            Popularity(4.6, emptyList()),
            60 * 60 * 1000,
            listOf(Category("Американская", "american", ""))
        ),
        Restaurant(
            "Macdonalds",
            "https://bipbap.ru/wp-content/uploads/2017/06/aa017506ac88f7bb89918bc1ffb.jpg",
            Popularity(4.5, emptyList()),
            40 * 60 * 1000,
            listOf(Category("Американская", "american", ""))
        ),
        Restaurant(
            "Dodo Pizza",
            "https://bipbap.ru/wp-content/uploads/2017/06/eda-ne-tolko-005.jpg",
            Popularity(4.3, emptyList()),
            25 * 60 * 1000,
            listOf(Category("Итальянская", "italian", ""), Category("Американская", "american", ""))
        ),
        Restaurant(
            "Harakiri",
            "https://bipbap.ru/wp-content/uploads/2017/06/4-3.jpg",
            Popularity(3.7, emptyList()),
            90 * 60 * 1000,
            listOf(Category("Восточная", "asia", ""))
        ),
        Restaurant(
            "Элитный", "https://v-georgia-com.exactdn.com/wp-content/uploads/2016/03/221.jpg?lossy=1&quality=60&w=1200&ssl=1", Popularity(4.8, emptyList()), 60 * 60 * 1000, listOf(
                Category("Восточная", "asia", ""),
                Category("Мексиканская", "mehico", ""),
                Category("Русская", "russia", ""),
                Category("Итальянская", "italian", ""),
                Category("Американская", "american", "")
            )
        )
    )
}