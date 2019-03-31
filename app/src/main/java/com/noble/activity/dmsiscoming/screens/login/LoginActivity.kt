package com.noble.activity.dmsiscoming.screens.login

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.noble.activity.dmsiscoming.R
import com.noble.activity.dmsiscoming.screens.common.BaseActivity
import com.noble.activity.dmsiscoming.screens.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), View.OnClickListener {
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(TAG, "onCreate")

        loginButton.setOnClickListener(this)

        loginViewModel = initViewModel()
        loginViewModel.goToHomeScreen.observe(this, Observer {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        })
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.loginButton ->
                loginViewModel.onLoginClick(
                    email = emailInput.text.toString(),
                    password = passwordInput.text.toString()
                )
        }
    }

    companion object {
        const val TAG = "LoginActivity"
    }
}