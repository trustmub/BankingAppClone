package com.trustathanas.absaclone.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trustathanas.absaclone.activities.auth.AuthResource
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.models.LoginModel
import com.trustathanas.absaclone.models.Response
import com.trustathanas.absaclone.repositories.AuthRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: AuthRepository

    private val _triesError: MutableLiveData<String> = MutableLiveData()
    val exceedTriesMessage: LiveData<String> = _triesError


    fun observerAuthState() = repository.observerAuthState()

    fun setObserverAuthState(state: LiveData<AuthResource<Response>>) = repository.setObserverAuthState(state)

    fun loginUser(login: Login) = repository.loginUser(login)

    fun manuallyAddUser(user: LoginModel) = repository.manuallyAddUser(user)

    fun reload() {
        println("Reload view model clicked")
    }

}