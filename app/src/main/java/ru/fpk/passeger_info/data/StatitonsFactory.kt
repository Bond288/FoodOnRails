package ru.fpk.passeger_info.data

import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class StatitonsFactory @Inject constructor() {

    fun stations(passenger: Passenger) = Single.just(
        listOf(
            Station("Аргыз", Calendar.getInstance()),
            Station("Дружинино", Calendar.getInstance()),
            Station("Екатеринбург Пасс.", Calendar.getInstance()),
            Station("Тюмень", Calendar.getInstance()),
            Station("Ишим", Calendar.getInstance()),
            Station("Омск", Calendar.getInstance()),
            Station("Барабинск", Calendar.getInstance())
        )
    )
}