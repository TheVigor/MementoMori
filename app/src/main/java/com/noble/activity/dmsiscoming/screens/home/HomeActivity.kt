package com.noble.activity.dmsiscoming.screens.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.noble.activity.dmsiscoming.R
import com.noble.activity.dmsiscoming.screens.common.BaseActivity
import com.noble.activity.dmsiscoming.screens.common.setupAuthGuard

class HomeActivity : BaseActivity(0) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupAuthGuard {
            setupBottomNavigation()
        }
    }
}
