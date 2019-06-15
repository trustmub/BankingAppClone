package com.trustathanas.absaclone

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.trustathanas.absaclone.activities.auth.AuthResource
import com.trustathanas.absaclone.models.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private val cachedUser: MediatorLiveData<AuthResource<User>> = MediatorLiveData()

    fun authenticateWithId(source: LiveData<AuthResource<User>>) {
        if (cachedUser != null) {
            cachedUser.value = AuthResource.loading(null as User?)
            cachedUser.addSource(source) { userAuthResource ->
                cachedUser.value = userAuthResource
                cachedUser.removeSource(source)
            }
        }
    }

    fun getAuthUser(): LiveData<AuthResource<User>> {
        return cachedUser
    }
}