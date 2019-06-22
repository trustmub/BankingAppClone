package com.trustathanas.absaclone.activities.home.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.trustathanas.absaclone.SessionManager
import com.trustathanas.absaclone.activities.auth.AuthResource
import com.trustathanas.absaclone.models.Response
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var sessionManager: SessionManager

    fun logout() {
        sessionManager.logout()
    }

    fun getUserInfo(): LiveData<AuthResource<Response>> {
        return sessionManager.getAuthUser()
    }
}