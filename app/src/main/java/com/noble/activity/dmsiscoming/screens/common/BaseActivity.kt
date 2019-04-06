package com.noble.activity.dmsiscoming.screens.common

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.noble.activity.dmsiscoming.R
import com.noble.activity.dmsiscoming.screens.home.HomeActivity
import com.noble.activity.dmsiscoming.screens.login.LoginActivity
import com.noble.activity.dmsiscoming.screens.profile.ProfileActivity
import kotlinx.android.synthetic.main.bottom_navigation_view.*

abstract class BaseActivity(val navNumber: Int) : AppCompatActivity() {
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

    override fun onResume() {
        super.onResume()
        if (bottom_navigation_view != null) {
            bottom_navigation_view.menu.getItem(navNumber).isChecked = true
        }
    }

    inline fun <reified T : ViewModel> initViewModel(): T =
        ViewModelProviders.of(this, ViewModelFactory(
            application,
            commonViewModel)).get(T::class.java)

    fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    fun setupBottomNavigation() {
        bottom_navigation_view.setIconSize(29f, 29f)
        bottom_navigation_view.setTextVisibility(false)
        bottom_navigation_view.enableItemShiftingMode(false)
        bottom_navigation_view.enableShiftingMode(false)
        bottom_navigation_view.enableAnimation(false)

        for (i in 0 until bottom_navigation_view.menu.size())
            bottom_navigation_view.setIconTintList(i, null)

        bottom_navigation_view.setOnNavigationItemSelectedListener {
            val nextActivity =
                when (it.itemId) {
                    R.id.nav_item_home -> HomeActivity::class.java
                    R.id.nav_item_profile -> ProfileActivity::class.java
                    else -> null

                }
            if (nextActivity != null) {
                val intent = Intent(this, nextActivity)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
                overridePendingTransition(0, 0)
                finish()
                true
            } else {
                false
            }
        }


    }

}