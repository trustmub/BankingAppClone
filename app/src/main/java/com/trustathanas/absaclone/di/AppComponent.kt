package com.trustathanas.absaclone.di

import android.app.Application
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.SessionManager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ActivityBuilderModule::class,
            AppModule::class,
            ViewModelFactoryModule::class
        ]
)
interface AppComponent : AndroidInjector<App> {

    val sessionManager: SessionManager

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}