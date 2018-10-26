package com.trustathanas.absaclone.webservices

import android.arch.lifecycle.LiveData
import com.trustathanas.absaclone.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface AuthService {
    //    @GET("users/{user}/repos")
//    fun login(@Path("user") user: String): Call<AuthModel>

    @POST("login/")
    fun login(@Body login: Login): Call<AuthResponse>

    @Headers("Content-Type: application/json")
    @POST("login/register/")
    fun register(@Body register: Register): Call<RegisterResponse>
}