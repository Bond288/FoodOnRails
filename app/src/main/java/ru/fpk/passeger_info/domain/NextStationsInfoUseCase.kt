package ru.fpk.passeger_info.domain

import io.reactivex.Observable
import ru.fpk.passeger_info.data.PassengerInfoProvider
import ru.fpk.passeger_info.data.Station
import ru.fpk.passeger_info.data.StatitonsFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NextStationsInfoUseCase @Inject constructor(
    private val factory: StatitonsFactory,
    private val passengerInfoProvider: PassengerInfoProvider
) {

    fun showNextStations(): Observable<List<Station>> = passengerInfoProvider.getInfo()
        .flatMap { factory.stations(it) }
        .toObservable()
}