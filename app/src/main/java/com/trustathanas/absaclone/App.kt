package com.trustathanas.absaclone

import android.content.Context
import com.trustathanas.absaclone.di.AppComponent
import com.trustathanas.absaclone.di.DaggerAppComponent
import com.trustathanas.absaclone.utilities.ApplicationDatabaseInstance
import com.trustathanas.absaclone.utilities.SharedPreferencesMain
import com.trustathanas.absaclone.webservices.AuthAPI
import com.trustathanas.absaclone.webservices.AuthService
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
        lateinit var executorService: ExecutorService
        lateinit var applicationDatabase: ApplicationDatabaseInstance
        val webServices = AuthAPI.getApiInstance()!!.create(AuthService::class.java)

    }

    override fun onCreate() {
        super.onCreate()
        initializeApplication()
    }

    private fun initializeApplication() {
        appContext = applicationContext
        prefes = SharedPreferencesMain(appContext)
        executorService = Executors.newCachedThreadPool()
        applicationDatabase = ApplicationDatabaseInstance.getDatabase(applicationContext)!!
    }

    /**Create the dependency injection singleton object*/

//    companion object InjectorUtilityMain {
//
//        fun provideLoginViewModelFactory(context: Context): LoginViewModelFactory {
//            val appDatabase = ApplicationDatabaseInstance.getDatabase(context)
//            val repository = LoginRepository.getInstance(appDatabase?.loginDao())
//            return LoginViewModelFactory(repository)
//        }
//    }
}