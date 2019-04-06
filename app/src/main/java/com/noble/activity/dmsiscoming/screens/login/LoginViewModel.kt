package com.noble.activity.dmsiscoming.screens.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.noble.activity.dmsiscoming.dembelStorage
import com.noble.activity.dmsiscoming.screens.common.CommonViewModel
import com.noble.activity.dmsiscoming.screens.common.SingleLiveEvent
import com.noble.activity.dmsiscoming.storage.LoginState
import java.text.SimpleDateFormat
import java.util.*

val DATE_FORMAT = "dd/MM/yyyy"

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

    private fun mkCalendar(mDay: Int, mMonth: Int, mYear: Int): Calendar {
        val cal = Calendar.getInstance()
        cal.set(Calendar.YEAR, mYear)
        cal.set(Calendar.MONTH, mMonth)
        cal.set(Calendar.DAY_OF_MONTH, mDay)

        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)

        return cal
    }

    fun getDateLong(mDay: Int, mMonth: Int, mYear: Int): Long {
        val cal = mkCalendar(mDay, mMonth, mYear)
        return cal.timeInMillis
    }

    fun updateDateStr(mDay: Int, mMonth: Int, mYear: Int, isStartDate: Boolean) {

        val cal = mkCalendar(mDay, mMonth, mYear)
        val sdf = SimpleDateFormat(DATE_FORMAT, Locale.US)

        val txtDate = sdf.format(cal.time)

        if (isStartDate) {
            startDateStr.value = txtDate
        } else {
            endDateStr.value = txtDate
        }
    }



}