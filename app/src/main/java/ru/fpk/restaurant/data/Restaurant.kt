package ru.fpk.restaurant.data

import ru.fpk.categories.data.Category
import ru.fpk.popularity.Popularity

data class Restaurant(
    val name: String,
    val image: String,
    val rating: Popularity,
    val timeOfPreparing: Long,
    val categories: List<Category>
)