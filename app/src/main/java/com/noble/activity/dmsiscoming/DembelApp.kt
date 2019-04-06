package com.noble.activity.dmsiscoming

import android.app.Application
import com.noble.activity.dmsiscoming.storage.DembelStorage

class DembelApp : Application() {
    val dembelStorage by lazy {DembelStorage(applicationContext)}
}