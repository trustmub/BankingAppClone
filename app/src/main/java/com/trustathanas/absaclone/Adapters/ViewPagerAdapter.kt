package com.trustathanas.absaclone.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.trustathanas.absaclone.activities.fragments.*


internal class ViewPagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentStatePagerAdapter(fm) {

    private val fragmentList: Array<androidx.fragment.app.Fragment> = arrayOf<androidx.fragment.app.Fragment>(WelcomeFragmentOne(), WelcomeFragmentTwo(), WelcomeFragmentThree(), WelcomeFragmentFour(), WelcomeFragmentFive())

    override fun getItem(i: Int): androidx.fragment.app.Fragment? {
        println("Get Item at $i On ViewPager")
        return fragmentList[i]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

}