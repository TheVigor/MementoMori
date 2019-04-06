package com.noble.activity.dmsiscoming.storage

import android.content.Context
import android.content.SharedPreferences

class DembelStorage (context: Context) {
    private val PREFS_FILENAME = "dembel_prefs"

    private val DEMBEL_NAME = "dembel_name"

    private val DEMBEL_START_DATE = "start_date"
    private val DEMBEL_END_DATE = "end_date"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)

    var dembelName: String
        get() = prefs.getString(DEMBEL_NAME, "")
        set(value) = prefs.edit().putString(DEMBEL_NAME, value).apply()

    var startDate: Long
        get() = prefs.getLong(DEMBEL_START_DATE, 0)
        set(value) = prefs.edit().putLong(DEMBEL_START_DATE, value).apply()

    var endDate: Long
        get() = prefs.getLong(DEMBEL_END_DATE, 0)
        set(value) = prefs.edit().putLong(DEMBEL_END_DATE, value).apply()

    fun isDembelLoggedIn() = !dembelName.trim().isEmpty() &&
            startDate != 0L && endDate != 0L

    fun validateDembel(name: String, start: Long, end: Long): LoginState {
        if (name.trim().isEmpty()) {
            //context.showToast("Soldier name can't be empty")
            return LoginState.EMPTY_NAME
        }

        if (start == 0L) {
            //context.showToast("Start date can't be empty")
            return LoginState.EMPTY_START_DATE
        }

        if (end == 0L) {
            //context.showToast("End date can't be empty")
            return LoginState.EMPTY_END_DATE
        }

        if (start > end) {
            //context.showToast("End date should be after start date")
            return LoginState.START_GREATER_END
        }

        return LoginState.SUCCESS
    }

    fun updateDembel(name: String, start: Long, end: Long) {
        this.apply {
            dembelName = name
            startDate = start
            endDate = end
        }
    }

    fun resetDembel() = updateDembel("", 0, 0)
}