package ru.fpk.meal.data

import io.reactivex.Single
import ru.fpk.restaurant.data.Restaurant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealsListFactory @Inject constructor(){
    fun mealsList(restaurant: Restaurant): Single<List<Meal>>{
        return when(restaurant.name){
            "KFC" -> Single.just(
                listOf(
                    Meal(
                        "Ножки",
                        listOf("Курица", "Специи"),
                        "https://www.google.ru/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=2ahUKEwjIsr_t5vPkAhWJlosKHdBaAgkQjRx6BAgBEAQ&url=https%3A%2F%2Fmetro.co.uk%2F2019%2F03%2F14%2Fkfc-is-inviting-you-to-come-cook-your-own-chicken-in-their-restaurants-kitchens-8902830%2F&psig=AOvVaw0ciqX43lNHy7FVFl2QCm04&ust=1569769933658961",
                        160.00
                        ),
                    Meal(
                        "Крылья",
                        listOf("Курица", "Специи"),
                        "https://www.google.ru/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=2ahUKEwjNq-mf5_PkAhXxtYsKHUIiA7gQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.mirror.co.uk%2Fmoney%2Fkfc-selling-bucket-20-hot-16538298&psig=AOvVaw0ciqX43lNHy7FVFl2QCm04&ust=1569769933658961",
                        120.00
                    ),
                    Meal(
                        "Филе",
                        listOf("Курица", "Специи"),
                        "https://www.google.ru/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=2ahUKEwiowpa55_PkAhUQAhAIHV01CxEQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.ledgerbennett.com%2Fblog%2Fsocial-media-kfc-chicken-gate%2F&psig=AOvVaw0ciqX43lNHy7FVFl2QCm04&ust=1569769933658961",
                       200.00
                    ),
                    Meal(
                        "Твистер",
                        listOf("Курица", "Овощи", "Специи"),
                        "https://www.google.ru/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=2ahUKEwi1wq7a5_PkAhWslYsKHSjmB7IQjRx6BAgBEAQ&url=https%3A%2F%2Firecommend.ru%2Fcontent%2Ffastfud-kfc-tvister-dzhunior&psig=AOvVaw0snteOZy0Gv4kMsaXxBlBa&ust=1569770161939496",
                        150.00
                    )
                )
            )
            else -> Single.just(emptyList())
        }
    }
}