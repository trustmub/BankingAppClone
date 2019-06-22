package com.trustathanas.absaclone.di.home

import com.trustathanas.absaclone.activities.home.home.HomeFragment
import com.trustathanas.absaclone.activities.home.MessageFragment
import com.trustathanas.absaclone.activities.home.MoreFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesMessageFragment(): MessageFragment

    @ContributesAndroidInjector
    abstract fun contributesMoreFragment(): MoreFragment

}