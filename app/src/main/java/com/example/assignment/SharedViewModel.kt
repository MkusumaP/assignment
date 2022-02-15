package com.example.assignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<CharSequence> = MutableLiveData()
    val message = MutableLiveData<String>()

    fun setMessage(text: String){
        message.value = text
    }
}