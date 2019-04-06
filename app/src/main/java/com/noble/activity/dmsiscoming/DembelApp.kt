package com.noble.activity.dmsiscoming

import android.app.Application
import com.noble.activity.dmsiscoming.storage.DembelStorage

val dembelStorage: DembelStorage by lazy { DembelApp.dembelStorage }

class DembelApp : Application() {

    companion object {
        lateinit var dembelStorage: DembelStorage
    }

    override fun onCreate() {
        super.onCreate()
        dembelStorage = DembelStorage(applicationContext)
    }

}