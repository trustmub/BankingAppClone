package com.trustathanas.absaclone

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.trustathanas.absaclone.activities.auth.AuthResource
import com.trustathanas.absaclone.models.Customer
import com.trustathanas.absaclone.models.Response
import com.trustathanas.absaclone.models.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private val cachedUser: MediatorLiveData<AuthResource<Response>> = MediatorLiveData()
    private val cachedCustomer: MediatorLiveData<AuthResource<Customer>> = MediatorLiveData()

    fun authenticate(source: LiveData<AuthResource<Response>>) {
        if (cachedUser != null) {
            cachedUser.value = AuthResource.loading(null as Response?)
            cachedUser.addSource(source) { userAuthResource ->
                cachedUser.value = userAuthResource
                cachedUser.removeSource(source)
            }
        }
    }

    fun getAuthUser(): LiveData<AuthResource<Response>> {
        return cachedUser
    }
}