package com.trustathanas.absaclone.webservices

import com.trustathanas.absaclone.models.AuthResponse
import com.trustathanas.absaclone.models.Login
import com.trustathanas.absaclone.models.Register
import com.trustathanas.absaclone.models.RegisterResponse
import com.trustathanas.absaclone.models.account_services.AccountServices
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface AuthService {
    //    @GET("users/{user}/repos")
//    fun login(@Path("user") user: String): Call<AuthModel>

    @Headers("Content-Type: application/json")
    @POST("login/")
    suspend fun login(@Body login: Login): Response<AuthResponse>

    @POST("login/")
    fun userLogin(@Body login: Login): Response<AuthResponse>

    @Headers("Content-Type: application/json")
    @POST("login/register/")
    fun register(@Body register: Register): Call<RegisterResponse>

    @POST("account/services/")
    fun accountServices(@Body login: Login): Call<AccountServices>
}