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
}