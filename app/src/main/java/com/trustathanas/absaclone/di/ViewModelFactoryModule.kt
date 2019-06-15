package com.trustathanas.absaclone.di

import android.arch.lifecycle.ViewModelProvider
import com.trustathanas.absaclone.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindsViewModelProviderVactory(providerFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}