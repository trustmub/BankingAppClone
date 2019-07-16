package com.trustathanas.absaclone.di.register

import dagger.Module

/**
 * all classes that must be available only to the @RegScope which are other than the globally declared ones.
 *
 * @sample
 *      @RegScope // and other relevant scope name
 *      @Provides
 *      @JvmStatic
 *      internal fun providesSampleClassOnlyOnThisScope(): SampleClassOnlyOnThisScope {
 *          return SampleClassOnlyOnThisScope()
 *      }
 *
 */

@Module(
        includes = [RegRepositoryModule::class]
)
abstract class RegisterModule {

}