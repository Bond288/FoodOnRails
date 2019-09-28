package ru.fpk.rx

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject

fun <T> BehaviorSubject<T>.startIfEmpty(load: Single<T>): Observable<T> {
    return if (isEmpty.blockingGet()) {
        load.map {
            this.onNext(it)
            it
        }.toObservable()
    } else {
        this
    }
}