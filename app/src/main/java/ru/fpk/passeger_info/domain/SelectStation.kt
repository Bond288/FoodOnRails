package ru.fpk.passeger_info.domain

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import ru.fpk.passeger_info.data.PassengerInfoProvider
import ru.fpk.passeger_info.data.Station
import ru.fpk.passeger_info.data.StatitonsFactory
import ru.fpk.rx.startIfEmpty
import javax.inject.Inject

class SelectStation @Inject constructor(
    private val passengerInfoProvider: PassengerInfoProvider,
    private val factory: StatitonsFactory
) {
    private val selectStationSubject = BehaviorSubject.create<Station>()

    fun selectStation(): Observable<Station> = selectStationSubject.startIfEmpty(load())

    fun change(station: Station) {
        selectStationSubject.onNext(station)
    }

    fun load(): Single<Station> = passengerInfoProvider.getInfo()
        .flatMap {
            factory.stations(it)
                .map { station -> station.first() }
        }

}
