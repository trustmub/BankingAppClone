package com.trustathanas.absaclone.di.Auth

import com.trustathanas.absaclone.models.LoginDao
import com.trustathanas.absaclone.models.Room.AppDatabase
import com.trustathanas.absaclone.webservices.AuthService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit

/**
 * This module holds the Apis to be used in the AuthScope of this application.
 * @sample
 *          @AuthScope
 *          @Provides     // this anotation is uses when the function has a body
 *          static fun providesAuthApi(Retrofit retrofit): AuthApi {
 *              return retrofit.create(AuthApi.class);
 *          }
 *
 * NB: note the classes are abstract for performance purposes.
 */
@Module
object  AuthModule {

    @AuthScope
    @Provides
    @JvmStatic
    internal fun providesAuthService(retrofit: Retrofit): AuthService = retrofit.create(AuthService::class.java)


    @AuthScope
    @Provides
    @JvmStatic
    internal fun providesLoginDao(appDatabase: AppDatabase): LoginDao {
        return appDatabase.loginDao()
    }

}