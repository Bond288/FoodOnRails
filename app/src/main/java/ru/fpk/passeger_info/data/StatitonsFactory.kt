package ru.fpk.passeger_info.data

import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class StatitonsFactory @Inject constructor() {

    fun stations(passenger: Passenger) = Single.just(
        listOf(
            Station("первая", Calendar.getInstance()),
            Station("Вторая", Calendar.getInstance())
        )
    )
}