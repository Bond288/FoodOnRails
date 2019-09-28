package ru.fpk.mvvm

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class RxViewModel : ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    protected fun add(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    protected fun clear(){
        compositeDisposable.clear()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}