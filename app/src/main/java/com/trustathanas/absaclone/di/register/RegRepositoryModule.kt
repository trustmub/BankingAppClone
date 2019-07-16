package com.trustathanas.absaclone.di.register

import com.trustathanas.absaclone.repositories.RegRepository
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RegRepositoryModule {

    @ContributesAndroidInjector
    abstract fun contributesRegRepository(): RegRepository
}