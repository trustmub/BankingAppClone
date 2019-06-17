package com.trustathanas.absaclone

import android.content.Context
import com.trustathanas.absaclone.di.DaggerAppComponent
import com.trustathanas.absaclone.utilities.ApplicationDatabaseInstance
import com.trustathanas.absaclone.utilities.SharedPreferencesMain
import com.trustathanas.absaclone.webservices.AuthAPI
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
//        return null
    }

    companion object {
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