package com.trustathanas.absaclone.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.SessionManager
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.models.account_services.AccountServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor() {

    @Inject
    lateinit var sessionManager: SessionManager

    fun logoutMain() {
        sessionManager.logout()
    }
}