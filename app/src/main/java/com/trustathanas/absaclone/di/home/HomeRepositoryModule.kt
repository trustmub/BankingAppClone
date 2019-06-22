package com.trustathanas.absaclone.di.home

import com.trustathanas.absaclone.repositories.HomeRepository
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeRepositoryModule {

    @ContributesAndroidInjector
    abstract fun bindsLoginRepository(): HomeRepository
}