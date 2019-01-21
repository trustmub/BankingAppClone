package com.trustathanas.absaclone.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.models.account_services.AccountServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {

    fun accountServices(user: Login): LiveData<AccountServices> {
        val result: MutableLiveData<AccountServices> = MutableLiveData()
        App.webServices.accountServices(user).enqueue(AccountServicesCallback(result))
        return result

    }

    class AccountServicesCallback(result: MutableLiveData<AccountServices>) : Callback<AccountServices> {
        override fun onFailure(call: Call<AccountServices>, t: Throwable) {
        }

        override fun onResponse(call: Call<AccountServices>, response: Response<AccountServices>) {

        }

    }
}