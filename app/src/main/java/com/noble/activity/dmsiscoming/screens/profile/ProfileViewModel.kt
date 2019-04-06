package com.noble.activity.dmsiscoming.screens.profile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.noble.activity.dmsiscoming.screens.common.CommonViewModel
import com.noble.activity.dmsiscoming.screens.common.SingleLiveEvent

class ProfileViewModel(private val commonViewModel: CommonViewModel) : ViewModel() {
    private val _goToLoginScreen = SingleLiveEvent<Unit>()
    val goToLoginScreen: LiveData<Unit> = _goToLoginScreen

    fun onLogoutClick() {
        _goToLoginScreen.value = Unit
    }

}