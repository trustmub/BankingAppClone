package com.trustathanas.absaclone.di

import android.app.Application
import androidx.room.Room
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.models.Room.AppDatabase
import com.trustathanas.absaclone.utilities.Constants
import com.trustathanas.absaclone.utilities.Constants.DATABASE_NAME
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
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    @JvmStatic
    internal fun providesRequestOptions(): RequestOptions {
        return RequestOptions
                .placeholderOf(R.drawable.ic_account_circle_black_24dp)
                .error(R.drawable.ic_account_circle_black_24dp)
    }

    @Singleton
    @Provides
    @JvmStatic
    internal fun providesGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions)
    }

    @Singleton
    @Provides
    @JvmStatic
    internal fun provideAppDrawable(application: Application): Drawable {
        return ContextCompat.getDrawable(application, R.drawable.ic_account_circle_black_24dp) as Drawable
    }


}