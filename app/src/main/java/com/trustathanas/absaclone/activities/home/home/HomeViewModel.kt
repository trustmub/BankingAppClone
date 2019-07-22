package com.trustathanas.absaclone.activities.home.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trustathanas.absaclone.SessionManager
import com.trustathanas.absaclone.activities.auth.AuthResource
import com.trustathanas.absaclone.models.Response
import javax.inject.Inject

class HomeViewModel @Inject constructor(var sessionManager: SessionManager) : ViewModel() {

    private val _clientFullName = MutableLiveData<String>()
    val clientFullName: LiveData<String> = _clientFullName

    private val _balance = MutableLiveData<String>()
    val balance: LiveData<String> = _balance

    private val _accountType = MutableLiveData<String>()
    val accountType: LiveData<String> = _accountType

    private val _accountTypeLabel = MutableLiveData<String>()
    val accountTypeLabel: LiveData<String> = _accountTypeLabel

    private val _accountNumber = MutableLiveData<String>()
    val accountNumber: LiveData<String> = _accountNumber

    fun logout() {
        sessionManager.logout()
    }

    fun getUserInfo(): LiveData<AuthResource<Response>> {
        val sessionManager = sessionManager.getAuthUser()
        setClientDetails(sessionManager.value)
        return sessionManager
    }

    private fun setClientDetails(value: AuthResource<Response>?) {
        value?.let { authResource ->
            authResource.data.let { response ->
                response?.let {
                    _clientFullName.value = it.customer.fullName
                    _balance.value = it.customer.balance.toString()
                    _accountType.value = it.customer.accountType
                    _accountNumber.value = it.customer.accountNumber.toString()
                    _accountTypeLabel.value = "Personal Bank account"
                }
            }
        }
    }

    fun getUserInformation() {
        setClientDetails(sessionManager.getAuthUser().value)
    }
}