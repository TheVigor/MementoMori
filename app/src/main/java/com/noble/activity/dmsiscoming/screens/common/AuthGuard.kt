package com.noble.activity.dmsiscoming.screens.common

import com.noble.activity.dmsiscoming.dembelStorage

class AuthGuard(private val activity: BaseActivity, f: (Unit) -> Unit) {

    init {
        if (!dembelStorage.isDembelLoggedIn()) {
            activity.goToLogin()
        } else {
            f
        }
    }
}

fun BaseActivity.setupAuthGuard(f: (Unit) -> Unit) {
    AuthGuard(this, f)
}