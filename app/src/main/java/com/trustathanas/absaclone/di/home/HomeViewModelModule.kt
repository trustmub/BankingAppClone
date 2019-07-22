package com.trustathanas.absaclone.di.home

import androidx.lifecycle.ViewModel
import com.trustathanas.absaclone.activities.home.home.HomeViewModel
import com.trustathanas.absaclone.activities.home.MainViewModel
import com.trustathanas.absaclone.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
        includes = [HomeRepositoryModule::class]
)
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(viewModel: HomeViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(viewModel: MainViewModel): ViewModel
}