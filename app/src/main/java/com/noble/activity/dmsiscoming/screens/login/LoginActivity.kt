package com.noble.activity.dmsiscoming.screens.login

import android.app.DatePickerDialog
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.noble.activity.dmsiscoming.R
import com.noble.activity.dmsiscoming.screens.common.BaseActivity
import com.noble.activity.dmsiscoming.screens.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class LoginActivity : BaseActivity(-1), View.OnClickListener {
    private lateinit var loginViewModel: LoginViewModel

    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0

    private var startDate: Long = 0
    private var endDate: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(TAG, "onCreate")

        val cal = Calendar.getInstance()
        year = cal.get(Calendar.YEAR)
        month = cal.get(Calendar.MONTH)
        day = cal.get(Calendar.DAY_OF_MONTH)

        startDateButton.setOnClickListener(this)
        endDateButton.setOnClickListener(this)
        loginButton.setOnClickListener(this)

        loginViewModel = initViewModel()
        loginViewModel.goToHomeScreen.observe(this, Observer {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        })
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.startDateButton ->
                DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener{ _, mYear, mMonth, mDay ->
                        startDate = loginViewModel.getDateLong(mDay, mMonth, mYear)
                    }, year, month, day).show()
            R.id.endDateButton ->
                DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener{ _, mYear, mMonth, mDay ->
                        endDate = loginViewModel.getDateLong(mDay, mMonth, mYear)
                    }, year, month, day).show()
            R.id.loginButton ->
                loginViewModel.onLoginClick(
                    name = nameInput.text.toString(),
                    start = startDate,
                    end = endDate
                )
        }
    }

    companion object {
        const val TAG = "LoginActivity"
    }
}