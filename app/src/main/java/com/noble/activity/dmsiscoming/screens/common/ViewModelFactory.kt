package com.noble.activity.dmsiscoming.screens.common

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val app: Application,
                       private val commonViewModel: CommonViewModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return CommonViewModel() as T

//        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
//            return LoginViewModel(authManager, app, commonViewModel, onFailureListener) as T
//        } else {
//            error("Unknown view model class $modelClass")
//        }
    }
}