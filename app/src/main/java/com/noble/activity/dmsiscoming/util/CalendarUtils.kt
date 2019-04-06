package com.noble.activity.dmsiscoming.util

import java.text.SimpleDateFormat
import java.util.*

val DATE_FORMAT = "dd/MM/yyyy"

fun mkCalendar(mDay: Int, mMonth: Int, mYear: Int): Calendar {
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

fun mkCalendarMills(mDay: Int, mMonth: Int, mYear: Int): Long {
    val cal = mkCalendar(mDay, mMonth, mYear)
    return cal.timeInMillis
}

fun mkCalendarStr(mDay: Int, mMonth: Int, mYear: Int): String {
    val cal = mkCalendar(mDay, mMonth, mYear)
    val sdf = SimpleDateFormat(DATE_FORMAT, Locale.US)
    return sdf.format(cal.time)
}