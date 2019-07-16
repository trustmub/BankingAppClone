package com.trustathanas.absaclone.di.home

import com.trustathanas.absaclone.activities.home.home.ServiceListRecyclerAdapter
import dagger.Module
import dagger.Provides

/**
 * all classes that must be available only to the Home scope which are other than the globally declared ones.
 *
 * @sample
 *      @HomeScope // and other relevant scope name
 *      @Provides
 *      @JvmStatic
 *      internal fun providesSampleClassOnlyOnThisScope(): SampleClassOnlyOnThisScope {
 *          return SampleClassOnlyOnThisScope()
 *      }
 *
 */
@Module
object HomeModule {

    @HomeScope
    @Provides
    @JvmStatic
    internal fun providesServiceListRecyclerAdapter(): ServiceListRecyclerAdapter {
        return ServiceListRecyclerAdapter()
    }

}