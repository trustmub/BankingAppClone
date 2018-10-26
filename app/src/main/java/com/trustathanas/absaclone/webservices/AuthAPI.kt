package com.trustathanas.absaclone.webservices

import com.trustathanas.absaclone.utilities.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AuthAPI {

    private var instance: Retrofit? = null

    fun getApiInstance(): Retrofit? {
        if(instance == null){
            synchronized(this){
                if (instance == null){
                    instance = Retrofit.Builder()
                            .baseUrl(Constants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                }
            }
        }
        return instance
    }

}