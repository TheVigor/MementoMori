package com.noble.activity.dmsiscoming.screens.profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.noble.activity.dmsiscoming.R
import com.noble.activity.dmsiscoming.screens.common.AuthGuard
import com.noble.activity.dmsiscoming.screens.common.BaseActivity
import com.noble.activity.dmsiscoming.screens.common.setupAuthGuard
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity(1) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupBottomNavigation()

        logoutLabel.setOnClickListener {
            goToLogin()
        }

        setupAuthGuard {
        }
    }
}
