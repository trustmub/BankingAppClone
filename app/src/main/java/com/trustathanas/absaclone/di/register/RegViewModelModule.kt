package com.trustathanas.absaclone.di.register

import androidx.lifecycle.ViewModel
import com.trustathanas.absaclone.activities.register.RegViewModel
import com.trustathanas.absaclone.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RegViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RegViewModel::class)
    abstract fun bindsRegViewModel(view: RegViewModel): ViewModel

}