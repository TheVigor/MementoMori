package com.noble.activity.dmsiscoming.screens.common

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    lateinit var commonViewModel: CommonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        commonViewModel = ViewModelProviders.of(this).get(CommonViewModel::class.java)
        commonViewModel.errorMessage.observe(this, Observer { message ->
            message?.let {
                showToast(it)
            }
        })
    }

    inline fun <reified T : ViewModel> initViewModel(): T =
        ViewModelProviders.of(this, ViewModelFactory(
            application,
            commonViewModel)).get(T::class.java)

}