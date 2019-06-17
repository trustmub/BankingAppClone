package com.trustathanas.absaclone.di

import android.app.Application
import android.arch.persistence.room.Room
import com.trustathanas.absaclone.models.Room.AppDatabase
import com.trustathanas.absaclone.utilities.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Singleton

/**
 * This module will containa all the functions/items which will available throughout the life of the
 * application, eg retrofit instance, glide instance, room instance etc
 *
 */
@Module
object AppModule {

    @Singleton
    @Provides
    @JvmStatic
    internal fun providesThreadPoolInstance(): ExecutorService {
        return Executors.newCachedThreadPool()
    }

    @Singleton
    @Provides
    @JvmStatic
    internal fun providesRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    @Singleton
    @Provides
    @JvmStatic
    internal fun provideDatabaseInstance(context: Application): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "application_db").build()
    }


}