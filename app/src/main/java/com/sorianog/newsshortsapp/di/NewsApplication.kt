package com.sorianog.newsshortsapp.di

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "### onCreate() reached")
    }

    companion object {
        const val TAG = "NewsApplication"
    }
}