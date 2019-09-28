package ru.fpk.passeger_info.data

import io.reactivex.Single
import javax.inject.Inject

class PassengerInfoProvider @Inject constructor() {

    fun getInfo(): Single<Passenger> =
        Single.just(Passenger(0L, "Михаил", "Иванов", "Вагон 7 место 8"))
}