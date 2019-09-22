package com.trustathanas.absaclone.activities.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.models.LoginModel
import com.trustathanas.absaclone.models.Response
import com.trustathanas.absaclone.repositories.AuthRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class LoginViewModel @Inject constructor() : ViewModel() {

    private val ioContext: CoroutineContext = Dispatchers.IO
    private val uiContext: CoroutineContext = Dispatchers.Main

    private val uiScope = CoroutineScope(uiContext + Job())

    @Inject
    lateinit var repository: AuthRepository

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> = _loadingState


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

    fun attemptlogin() {
        uiScope.launch(Dispatchers.IO) {

        }
    }

    private fun showProgressBar(status: Boolean) {
        _loadingState.setValue(status)
    }

    fun actionOnResponse(userResource: AuthResource<Response>) {
        when (userResource.status) {
            AuthResource.Status.LOADING -> {
                showProgressBar(true)
            }
            AuthResource.Status.AUTHENTICATED -> {
                showProgressBar(false)
//                resetMarker()
//                startActivity(Intent(this, MainActivity::class.java))
                // set the session values and navigate to the home page
            }
            AuthResource.Status.ERROR -> {
//                resetMarker()
                showProgressBar(false)
                // show dialog of failed login
            }
            AuthResource.Status.NOT_AUTHENTICATED -> {
                showProgressBar(false)
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        uiScope.coroutineContext.cancel()
    }

}