package com.trustathanas.absaclone.di.Auth

import android.arch.lifecycle.ViewModel
import com.trustathanas.absaclone.di.ViewModelKey
import com.trustathanas.absaclone.activities.auth.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * This module will provide the view models to be used in the @AuthScope
 * @sample
 *          @Binds     // @Binds is used when the function does not have a body
 *          @IntoMap
 *          @ViewModelKey(AuthViewModel.class)
 *          abstract fun bindAuthViewModel(AuthViewModel viewModel): ViewModel;
 */
@Suppress("unused")
@Module(
        includes = [AuthRepositoryModule::class]
)
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindsLoginViewModel(viewModel: LoginViewModel): ViewModel

}