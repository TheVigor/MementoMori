package com.noble.activity.dmsiscoming.screens.profile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.noble.activity.dmsiscoming.dembelStorage
import com.noble.activity.dmsiscoming.screens.common.CommonViewModel
import com.noble.activity.dmsiscoming.screens.common.SingleLiveEvent

class ProfileViewModel(private val commonViewModel: CommonViewModel) : ViewModel() {
    private val _goToLoginScreen = SingleLiveEvent<Unit>()
    val goToLoginScreen: LiveData<Unit> = _goToLoginScreen

    fun onLogoutClick() {
        dembelStorage.resetDembel()
        _goToLoginScreen.value = Unit
    }

}