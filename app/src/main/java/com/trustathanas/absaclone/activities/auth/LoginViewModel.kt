package com.trustathanas.absaclone.activities.auth

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.models.LoginModel
import com.trustathanas.absaclone.models.Response
import com.trustathanas.absaclone.repositories.AuthRepository
import javax.inject.Inject


class LoginViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: AuthRepository


    private val _authState = MutableLiveData<AuthResource<Response>>()
    val authorisationState: LiveData<AuthResource<Response>> = _authState


    fun observerAuthState(): LiveData<AuthResource<Response>> {
        val response = repository.observerAuthState()
        _authState.value = response.value
        return response
    }

    fun setAuthorisationState() {
        _authState.setValue(repository.observerAuthState().value)
    }

    fun setObserverAuthState(state: LiveData<AuthResource<Response>>) {
        repository.setObserverAuthState(state)
    }

    fun loginUser(login: Login) = repository.loginUser(login)

    fun manuallyAddUser(user: LoginModel) = repository.manuallyAddUser(user)

    fun setLoggedInUserDetails(email: String, fullName: String, passCode: Int = 12345) {
        if (App.prefes.username.isNullOrEmpty()) App.prefes.username = email
        if (App.prefes.fullname.isNullOrEmpty()) App.prefes.fullname = fullName
        if (App.prefes.passCode.equals(null)) App.prefes.passCode = passCode
    }

}