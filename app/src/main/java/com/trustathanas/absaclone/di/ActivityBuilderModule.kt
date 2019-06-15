package com.trustathanas.absaclone.di

import com.trustathanas.absaclone.activities.auth.LoginActivity
import com.trustathanas.absaclone.activities.register.RegisterActivity
import com.trustathanas.absaclone.di.Auth.AuthModule
import com.trustathanas.absaclone.di.Auth.AuthScope
import com.trustathanas.absaclone.di.Auth.AuthViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = [AuthViewModelModule::class, AuthModule::class]
    )
    abstract fun contributesRegisterActivity(): RegisterActivity


    @AuthScope
    @ContributesAndroidInjector
    abstract fun contributesLoginActivity(): LoginActivity
}