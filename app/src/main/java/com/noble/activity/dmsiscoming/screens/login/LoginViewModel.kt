package com.noble.activity.dmsiscoming.screens.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.noble.activity.dmsiscoming.dembelStorage
import com.noble.activity.dmsiscoming.screens.common.CommonViewModel
import com.noble.activity.dmsiscoming.screens.common.SingleLiveEvent
import com.noble.activity.dmsiscoming.storage.LoginState
import com.noble.activity.dmsiscoming.util.mkCalendar
import com.noble.activity.dmsiscoming.util.mkCalendarMills
import com.noble.activity.dmsiscoming.util.mkCalendarStr
import java.text.SimpleDateFormat
import java.util.*

class LoginViewModel(private val commonViewModel: CommonViewModel) : ViewModel() {
    private val _goToHomeScreen = SingleLiveEvent<Unit>()
    val goToHomeScreen: LiveData<Unit> = _goToHomeScreen

    private val _startDateStr = MutableLiveData<String>()
    val startDateStr: MutableLiveData<String> = _startDateStr

    private val _endDateStr = MutableLiveData<String>()
    val endDateStr: MutableLiveData<String> = _endDateStr

    fun onLoginClick(name: String, start: Long, end: Long) {
        when (dembelStorage.validateDembel(name, start , end)) {
            LoginState.SUCCESS -> {
                dembelStorage.updateDembel(name, start , end)
                _goToHomeScreen.value = Unit
            }
            LoginState.EMPTY_NAME -> commonViewModel.setErrorMessage("Soldier name can't be empty")
            LoginState.EMPTY_START_DATE -> commonViewModel.setErrorMessage("Start date can't be empty")
            LoginState.EMPTY_END_DATE -> commonViewModel.setErrorMessage("End date can't be empty")
            LoginState.START_GREATER_END -> commonViewModel.setErrorMessage("End date should be after start date")
        }
    }

    fun getDateLong(mDay: Int, mMonth: Int, mYear: Int): Long {
        return mkCalendarMills(mDay, mMonth, mYear)
    }

    fun updateDateStr(mDay: Int, mMonth: Int, mYear: Int, isStartDate: Boolean) {
        val txtDate = mkCalendarStr(mDay, mMonth, mYear)

        if (isStartDate) {
            startDateStr.value = txtDate
        } else {
            endDateStr.value = txtDate
        }
    }



}