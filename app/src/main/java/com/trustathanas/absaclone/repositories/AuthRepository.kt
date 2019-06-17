package com.trustathanas.absaclone.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import com.trustathanas.absaclone.SessionManager
import com.trustathanas.absaclone.activities.auth.AuthResource
import com.trustathanas.absaclone.di.Auth.AuthScope
import com.trustathanas.absaclone.models.*
import com.trustathanas.absaclone.webservices.AuthService
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.ExecutorService
import javax.inject.Inject

@AuthScope
class AuthRepository @Inject constructor(private val sessionManager: SessionManager,
                                         private val authApi: AuthService,
                                         private val executor: ExecutorService,
                                         private val loginDao: LoginDao) {


    fun setObserverAuthState(state: LiveData<AuthResource<Response>>) {
        sessionManager.authenticate(state)
    }

    fun observerAuthState(): LiveData<AuthResource<Response>> {
        return sessionManager.getAuthUser()
    }

    fun loginUser(login: Login) {
        sessionManager.authenticate(loginUserCall(login))
    }

    private fun loginUserCall(login: Login): LiveData<AuthResource<Response>> {
        return LiveDataReactiveStreams.fromPublisher(
                authApi.userLogin(login)
                        .onErrorReturn(Function<Throwable, AuthResponse> {
                            val errorUser = AuthResponse()
                            errorUser.response!!.user.userNumber = -1
                            errorUser
                        })
                        .map(Function<AuthResponse, AuthResource<Response>> { user ->
                            if (user.response!!.user.userNumber.equals(-1)) {
                                AuthResource.error("Could not authenticate", null)
                            } else AuthResource.success(user.response)
                        })
                        .subscribeOn(Schedulers.io())
        )


    }

    fun manuallyAddUser(user: LoginModel) {
        executor.execute {
            loginDao.insertUser(user)
        }
    }
}