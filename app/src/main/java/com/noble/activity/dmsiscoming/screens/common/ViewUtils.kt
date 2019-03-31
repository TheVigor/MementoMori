package com.noble.activity.dmsiscoming.screens.common

import android.content.Context
import android.widget.Toast

fun Context.showToast(text: String?, duration: Int = Toast.LENGTH_SHORT) {
    text?.let { Toast.makeText(this, it, duration).show() }
}