package com.noble.activity.dmsiscoming.screens.common

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CommonViewModel: ViewModel() {
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun setErrorMessage(message: String?) {
        message ?: return
        _errorMessage.value = message
    }
}