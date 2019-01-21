/**
 * This is a singleton for LoginViewModelFactory provider class.
 *
 * */
package com.trustathanas.absaclone.utilities

import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.repositories.LoginRepository
import com.trustathanas.absaclone.viewmodels.factorties.LoginViewModelFactory

object InjectorUtility {

    fun provideLoginViewModelFactory(): LoginViewModelFactory {
        val repository = LoginRepository.getInstance(App.applicationDatabase.loginDao(), App.executorService)
        return LoginViewModelFactory(repository)
    }
}