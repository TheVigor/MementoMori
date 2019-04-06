package com.noble.activity.dmsiscoming.screens.profile

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.noble.activity.dmsiscoming.R
import com.noble.activity.dmsiscoming.screens.common.AuthGuard
import com.noble.activity.dmsiscoming.screens.common.BaseActivity
import com.noble.activity.dmsiscoming.screens.common.setupAuthGuard
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity(1), View.OnClickListener {
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupBottomNavigation()

        logoutLabel.setOnClickListener(this)

        profileViewModel = initViewModel()
        profileViewModel.goToLoginScreen.observe(this, Observer {
            goToLogin()
        })

        setupAuthGuard {
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.logoutLabel ->
                profileViewModel.onLogoutClick()
        }
    }


}
