package com.trustathanas.absaclone.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.trustathanas.absaclone.activities.fragments.*


internal class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragmentList: Array<Fragment> = arrayOf<Fragment>(WelcomeFragmentOne(), WelcomeFragmentTwo(), WelcomeFragmentThree(), WelcomeFragmentFour(), WelcomeFragmentFive())

    override fun getItem(i: Int): Fragment? {
        println("Get Item at $i On ViewPager")
        return fragmentList[i]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
}