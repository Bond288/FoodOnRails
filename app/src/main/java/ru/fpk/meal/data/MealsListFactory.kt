package ru.fpk.meal.data

import io.reactivex.Single
import ru.fpk.restaurant.data.Restaurant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealsListFactory @Inject constructor(){
    fun mealsList(restaurant: Restaurant): Single<List<Meal>>{
        return when(restaurant.name){
            "KFC" -> kfc()
            "Macdonalds" -> macdonalds()
            "Dodo Pizza" -> dodo()
            "Harakiri" -> harakiri()
            "Элитный" -> elite()
            else -> Single.just(emptyList())
        }
    }

    private fun kfc(): Single<List<Meal>> {
        return Single.just(
            listOf(
                Meal(
                    "Ножки",
                    listOf("Курица", "Специи"),
                    "https://s82079.cdn.ngenix.net/eQJqAgBWWoSUiBf7oG3kkfvE.png?dw=230",
                    160.00
                ),
                Meal(
                    "Крылья",
                    listOf("Курица", "Специи"),
                    "https://s82079.cdn.ngenix.net/bBT3VJ5NNWmKzcdtJRUTKphs.png?dw=230",
                    120.00
                ),
                Meal(
                    "Филе",
                    listOf("Курица", "Специи"),
                    "https://s82079.cdn.ngenix.net/Kq1eF5NBj287FHbv4gQr8xkb.png?dw=230",
                    200.00
                ),
                Meal(
                    "Твистер",
                    listOf("Курица", "Овощи", "Специи"),
                    "https://s82079.cdn.ngenix.net/MYzJ4vRR5ZbBcbw7DZBvbkEN.png?dw=230",
                    150.00
                )
            )
        )
    }

    private fun macdonalds(): Single<List<Meal>> {
        return Single.just(
            listOf(
                Meal(
                    "Биг Мак МакКомбо",
                    listOf("Биг Мак", "Картошка фри", "Кола"),
                    "https://mcdonalds.ru/upload/iblock/ef2/Big-Mak-MakKombo.png",
                    215.00
                ),
                Meal(
                    "Салат Цезарь",
                    listOf("Курица", "Салат"),
                    "https://mcdonalds.ru/upload/iblock/c2b/Salat-TSezar.png",
                    269.00
                ),
                Meal(
                    "Панини Тоскана",
                    listOf("Бифштекс", "Помидоры", "Руккола"),
                    "https://mcdonalds.ru/upload/iblock/0f2/Panini_Toskana.png",
                    179.00
                ),
                Meal(
                    "Макфлурри Де Люкс Карамельно-Шоколадное",
                    listOf("Молоко", "Вафели", "Шоколадная крошка"),
                    "https://mcdonalds.ru/upload/iblock/728/Makflurri-De-Lyuks-shokoladno_karamelnoe.png",
                    99.00
                )
            )
        )
    }

    private fun dodo(): Single<List<Meal>> {
        return Single.just(
            listOf(
                Meal(
                    "Испанские колбаски Чоризо",
                    listOf("Чеддер", "Чоризо"),
                    "https://dodopizza-a.akamaihd.net/static/Img/Products/Pizza/ru-RU/6702cf8c-858e-4891-ba74-ec023e2ba04d.jpg",
                    345.00
                ),
                Meal(
                    "Додо",
                    listOf("Ветчина", "Шампиньоны"),
                    "https://dodopizza-a.akamaihd.net/static/Img/Products/Pizza/ru-RU/fcbf1069-ed66-4331-93f8-864b00d11715.jpg",
                    445.00
                ),
                Meal(
                    "Паста Цыпленок и грибы",
                    listOf("Цыпленок", "Грибы"),
                    "https://dodopizza-a.akamaihd.net/static/Img/Products/Snacks/ru-RU/496e1d0d-80b3-4ea2-b867-62c9ef31f626.jpg",
                    265.00
                ),
                Meal(
                    "Чизкейк Нью-Йорк",
                    listOf("Творог", "Сахар", "Яйца"),
                    "https://dodopizza-a.akamaihd.net/static/Img/Products/Desserts/ru-RU/4906b9a7-a9df-4540-b34b-18767bc81426.jpg",
                    119.00
                )
            )
        )
    }

    private fun harakiri(): Single<List<Meal>> {
        return Single.just(
            listOf(
                Meal(
                    "СЯКЕ ТЕМПУРА",
                    listOf("Лосось", "Кабаяки"),
                    "https://www.xarakiri.ru/upload/iblock/917/917f1d2330f37995335e765fb571f94b.jpg",
                    230.00
                ),
                Meal(
                    "MINI-FILA",
                    listOf("Лосось", "Сливочный сыр"),
                    "https://www.xarakiri.ru/upload/iblock/40b/40b2f00e9f5dd6a54bf4f02d2d125860.jpg",
                    360.00
                ),
                Meal(
                    "КОЛЬЦА ТВОРОЖНЫЕ",
                    listOf("Творог", "Сгущенное молоко"),
                    "https://www.xarakiri.ru/upload/iblock/b10/b10b4ad1d0086e731bf7b9e89446c9ef.jpg",
                    80.00
                ),
                Meal(
                    "ЛОСОСЬ ХАРАКИРИ С РИСОМ",
                    listOf("Лосось", "Морковка", "Рис"),
                    "https://www.xarakiri.ru/upload/iblock/996/99699330b322ae30229e7f685f532393.jpg",
                    310.00
                )
            )
        )
    }

    private fun elite(): Single<List<Meal>> {
        return Single.just(
            listOf(
                Meal(
                    "Филе-Миньон",
                    listOf("Говядина"),
                    "https://goodman.ru/upload/iblock/e83/fileminion.jpg",
                    2450.00
                ),
                Meal(
                    "Стейк из Лосося",
                    listOf("Лосось"),
                    "https://goodman.ru/upload/iblock/7a1/Steyk-iz-lososya.png",
                    1290.00
                ),
                Meal(
                    "КЛАССИЧЕСКИЙ БУРГЕР ИЗ МРАМОРНОЙ ГОВЯДИНЫ",
                    listOf("Блэк Ангус"),
                    "https://goodman.ru/upload/iblock/803/%D0%9A%D0%BB%D0%B0%D1%81%D1%81%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9-%D0%B1%D1%83%D1%80%D0%B3%D0%B5%D1%80-%D0%B8%D0%B7-%D0%BC%D1%80%D0%B0%D0%BC%D0%BE%D1%80%D0%BD%D0%BE%D0%B9-%D0%B3%D0%BE%D0%B2%D1%8F%D0%B4%D0%B8%D0%BD%D1%8B.png",
                    790.00
                ),
                Meal(
                    "ЯГОДНО-ФРУКТОВЫЙ МИКС",
                    listOf("Ягоды", "Фрукты", "Микс"),
                    "https://goodman.ru/upload/iblock/134/%D0%AF%D0%B3%D0%BE%D0%B4%D0%BD%D0%BE-%D1%84%D1%80%D1%83%D0%BA%D1%82%D0%BE%D0%B2%D1%8B%D0%B9-%D0%BC%D0%B8%D0%BA%D1%81.jpg",
                    440.00
                )
            )
        )
    }
}
