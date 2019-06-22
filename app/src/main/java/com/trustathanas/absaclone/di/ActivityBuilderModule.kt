package com.trustathanas.absaclone.di

import com.trustathanas.absaclone.activities.auth.LoginActivity
import com.trustathanas.absaclone.activities.home.MainActivity
import com.trustathanas.absaclone.di.Auth.AuthModule
import com.trustathanas.absaclone.di.Auth.AuthScope
import com.trustathanas.absaclone.di.Auth.AuthViewModelModule
import com.trustathanas.absaclone.di.home.HomeFragmentBuildersModule
import com.trustathanas.absaclone.di.home.HomeModule
import com.trustathanas.absaclone.di.home.HomeScope
import com.trustathanas.absaclone.di.home.HomeViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

//    @AuthScope
//    @ContributesAndroidInjector(
//            modules = [AuthViewModelModule::class, AuthModule::class]
//    )
//    abstract fun contributesRegisterActivity(): RegisterActivity



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
}