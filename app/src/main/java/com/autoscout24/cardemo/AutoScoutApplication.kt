package com.autoscout24.cardemo

import android.app.Application
import android.os.Debug
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class AutoScoutApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.BUILD_TYPE=="debug"){
            Timber.plant(Timber.DebugTree())
        }
    }
}