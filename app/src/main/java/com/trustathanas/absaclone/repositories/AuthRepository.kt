package com.trustathanas.absaclone.repositories

import androidx.lifecycle.LiveData
import com.trustathanas.absaclone.SessionManager
import com.trustathanas.absaclone.activities.auth.AuthResource
import com.trustathanas.absaclone.models.*
import com.trustathanas.absaclone.webservices.AuthService
import java.util.concurrent.ExecutorService
import javax.inject.Inject

class AuthRepository @Inject constructor(private val sessionManager: SessionManager,
                                         private val authApi: AuthService,
                                         private val executor: ExecutorService,
                                         private val loginDao: LoginDao) : BaseResponseWrapper() {


    fun setObserverAuthState(state: LiveData<AuthResource<Response>>) {
        sessionManager.authenticate(state)
    }

    fun observerAuthState(): LiveData<AuthResource<Response>> {
        return sessionManager.getAuthUser()
    }

    suspend fun loginUser(login: Login): AuthResponse? {
//        sessionManager.authenticate(loginUserCall(login))
        return safeApiCall(call = { authApi.login(login) }, error = "Failed")
    }

//    private fun loginUserCall(login: Login): LiveData<AuthResource<Response>> {
//        return LiveDataReactiveStreams.fromPublisher(
//                authApi.userLogin(login)
//                        .onErrorReturn(Function<Throwable, AuthResponse> {
//                            val errorUser = AuthResponse(null)
////                            errorUser.response?.customer?.accountNumber = -1
//                            println("Error occurred with results $errorUser and $it")
//                            errorUser
//                        })
//                        .map(Function<AuthResponse, AuthResource<Response>> { user ->
//                            if (user.response?.user == null) {
//                                return@Function AuthResource.error("Could not authenticate", null)
//                            } else return@Function AuthResource.authenticated(user.response)
//                        })
//                        .subscribeOn(Schedulers.io()))
//
//    }

    fun manuallyAddUser(user: LoginModel) {
            loginDao.insertUser(user)
    }
}