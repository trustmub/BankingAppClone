package com.trustathanas.absaclone.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.trustathanas.absaclone.activities.fragments.*


internal class ViewPagerAdapter(fm: FragmentManager) : androidx.fragment.app.FragmentStatePagerAdapter(fm) {

    private val fragmentList: Array<Fragment> = arrayOf<Fragment>(WelcomeFragmentOne(), WelcomeFragmentTwo(), WelcomeFragmentThree(), WelcomeFragmentFour(), WelcomeFragmentFive())

    override fun getItem(i: Int): Fragment {
        println("Get Item at $i On ViewPager")
        return fragmentList[i]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

}