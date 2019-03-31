package com.noble.activity.dmsiscoming.screens.common

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.noble.activity.dmsiscoming.screens.login.LoginViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val app: Application,
                       private val commonViewModel: CommonViewModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(app, commonViewModel) as T
        } else {
            error("Unknown view model class $modelClass")
        }
    }
}