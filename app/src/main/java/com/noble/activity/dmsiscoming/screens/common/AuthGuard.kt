package com.noble.activity.dmsiscoming.screens.common


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