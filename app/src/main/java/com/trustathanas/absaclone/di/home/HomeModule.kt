package com.trustathanas.absaclone.di.home

import com.trustathanas.absaclone.activities.home.home.ServiceListRecyclerAdapter
import dagger.Module
import dagger.Provides

@Module
object HomeModule {

    @HomeScope
    @Provides
    @JvmStatic
    internal fun providesServiceListRecyclerAdapterr(): ServiceListRecyclerAdapter {
        return ServiceListRecyclerAdapter()
    }

}