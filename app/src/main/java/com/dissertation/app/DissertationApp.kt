package com.dissertation.app

import android.app.Application
import com.dissertation.BuildConfig
import timber.log.Timber

class DissertationApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}