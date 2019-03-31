package com.noble.activity.dmsiscoming.screens.login

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.noble.activity.dmsiscoming.R
import com.noble.activity.dmsiscoming.screens.common.CommonViewModel
import com.noble.activity.dmsiscoming.screens.common.SingleLiveEvent

class LoginViewModel(private val app: Application,
                     private val commonViewModel: CommonViewModel) : ViewModel() {
    private val _goToHomeScreen = SingleLiveEvent<Unit>()
    val goToHomeScreen: LiveData<Unit> = _goToHomeScreen

    fun onLoginClick(email: String, password: String) {
        if (validate(email, password)) {
            _goToHomeScreen.value = Unit
        } else {
            commonViewModel.setErrorMessage(app.getString(R.string.please_enter_email_and_password))
        }
    }

    private fun validate(email: String, password: String) =
        email.isNotEmpty() && password.isNotEmpty()

}