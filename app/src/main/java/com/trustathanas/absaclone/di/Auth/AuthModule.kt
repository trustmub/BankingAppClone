package com.trustathanas.absaclone.di.Auth

import dagger.Module

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
abstract class AuthModule {

}