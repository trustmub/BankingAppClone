package com.trustathanas.absaclone.di

import com.trustathanas.absaclone.activities.auth.LoginActivity
import com.trustathanas.absaclone.activities.home.MainActivity
import com.trustathanas.absaclone.activities.register.RegisterActivity
import com.trustathanas.absaclone.di.Auth.AuthModule
import com.trustathanas.absaclone.di.Auth.AuthScope
import com.trustathanas.absaclone.di.Auth.AuthViewModelModule
import com.trustathanas.absaclone.di.home.HomeFragmentBuildersModule
import com.trustathanas.absaclone.di.home.HomeModule
import com.trustathanas.absaclone.di.home.HomeScope
import com.trustathanas.absaclone.di.home.HomeViewModelModule
import com.trustathanas.absaclone.di.register.RegScope
import com.trustathanas.absaclone.di.register.RegViewModelModule
import com.trustathanas.absaclone.di.register.RegisterFragmentBuilderModule
import com.trustathanas.absaclone.di.register.RegisterModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = [AuthViewModelModule::class, AuthModule::class]
    )
    abstract fun contributesLoginActivity(): LoginActivity

    @HomeScope
    @ContributesAndroidInjector(
            modules = [HomeFragmentBuildersModule::class, HomeViewModelModule::class, HomeModule::class]
    )
    abstract fun constributesMainActivity(): MainActivity

    @RegScope
    @ContributesAndroidInjector(
            modules = [RegisterFragmentBuilderModule::class, RegisterModule::class, RegViewModelModule::class]
    )
    abstract fun contributesRegisterActivity(): RegisterActivity
}