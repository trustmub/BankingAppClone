package com.trustathanas.absaclone.di.Auth

import com.trustathanas.absaclone.repositories.AuthRepository
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class AuthRepositoryModule {

    @ContributesAndroidInjector
    abstract fun bindsLoginRepository(): AuthRepository
}