package com.noble.activity.dmsiscoming.screens.login

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.noble.activity.dmsiscoming.R
import com.noble.activity.dmsiscoming.dembelStorage
import com.noble.activity.dmsiscoming.screens.common.CommonViewModel
import com.noble.activity.dmsiscoming.screens.common.SingleLiveEvent
import com.noble.activity.dmsiscoming.storage.LoginState

class LoginViewModel(private val app: Application,
                     private val commonViewModel: CommonViewModel) : ViewModel() {
    private val _goToHomeScreen = SingleLiveEvent<Unit>()
    val goToHomeScreen: LiveData<Unit> = _goToHomeScreen

    fun onLoginClick(email: String, password: String) {
        when (dembelStorage.validateDembel("Ivan", 1 , 2)) {
            LoginState.SUCCESS -> {
                dembelStorage.updateDembel("Ivan", 1 , 2)
                _goToHomeScreen.value = Unit
            }
            LoginState.EMPTY_NAME -> commonViewModel.setErrorMessage("Soldier name can't be empty")
            LoginState.EMPTY_START_DATE -> commonViewModel.setErrorMessage("Start date can't be empty")
            LoginState.EMPTY_END_DATE -> commonViewModel.setErrorMessage("End date can't be empty")
            LoginState.START_GREATER_END -> commonViewModel.setErrorMessage("End date should be after start date")
        }
    }

    private fun processLoginState(email: String, password: String) =
        email.isNotEmpty() && password.isNotEmpty()

}