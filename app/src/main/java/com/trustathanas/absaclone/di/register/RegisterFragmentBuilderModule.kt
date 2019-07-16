package com.trustathanas.absaclone.di.register

import com.trustathanas.absaclone.activities.register.RegisterFragment
import com.trustathanas.absaclone.activities.register.RegisterLoginFragment
import com.trustathanas.absaclone.activities.register.RegisterWelcomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RegisterFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesRegisterFragment(): RegisterFragment

    @ContributesAndroidInjector
    abstract fun contrinutesRegisterLoginFragment(): RegisterLoginFragment

    @ContributesAndroidInjector
    abstract fun contributesRegisterWelcomeFragment(): RegisterWelcomeFragment

}