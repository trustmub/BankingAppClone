package com.trustathanas.absaclone.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.models.LoginModel
import com.trustathanas.absaclone.models.PasscodeModel
import com.trustathanas.absaclone.repositories.LoginRepository

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    fun addUser(user: LoginModel) = repository.addUser(user)

    fun getAllUsers() = repository.getAllUsers()

    fun accessCurrentUser() = repository.accessCurrentUser()

    fun login(login: Login) = repository.login(login)



    fun listenToPasscode(number: Int): LiveData<List<PasscodeModel>> {
        val passcodeList = MutableLiveData<List<PasscodeModel>>()
        var pass = mutableListOf<PasscodeModel>()
        pass.add(PasscodeModel(number))
        passcodeList.postValue(pass)
        return passcodeList
    }
}