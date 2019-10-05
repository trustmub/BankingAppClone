package com.trustathanas.absaclone

import android.annotation.SuppressLint
import android.content.Context
import com.trustathanas.absaclone.di.DaggerAppComponent
import com.trustathanas.absaclone.utilities.SharedPreferencesMain
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
//        return null
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var prefes: SharedPreferencesMain
        lateinit var appContext: Context

    }

    override fun onCreate() {
        super.onCreate()
        initializeApplication()
    }

    private fun initializeApplication() {
        appContext = applicationContext
        prefes = SharedPreferencesMain(appContext)
    }


}