package com.trustathanas.absaclone.webservices

import android.arch.lifecycle.LiveData
import com.trustathanas.absaclone.models.*
import com.trustathanas.absaclone.models.account_services.AccountServices
import io.reactivex.Flowable
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface AuthService {
    //    @GET("users/{user}/repos")
//    fun login(@Path("user") user: String): Call<AuthModel>

    @POST("login/")
    fun login(@Body login: Login): Call<AuthResponse>

    @POST("login/")
    fun userLogin(@Body login: Login): Flowable<AuthResponse>

    @Headers("Content-Type: application/json")
    @POST("login/register/")
    fun register(@Body register: Register): Call<RegisterResponse>

    @POST("account/services/")
    fun accountServices(@Body login: Login): Call<AccountServices>
}