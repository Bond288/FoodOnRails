package ru.fpk.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiscountsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Акции в ресторанах"
    }
    val text: LiveData<String> = _text
}