package com.noble.activity.dmsiscoming.screens.common

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

class AuthGuard(private val activity: BaseActivity, f: (Unit) -> Unit) {

    init {
        val user = null
        if (user == null) {
            activity.goToLogin()
        } else {
            f
        }
    }

}

fun BaseActivity.setupAuthGuard(f: (Unit) -> Unit) {
    AuthGuard(this, f)
}