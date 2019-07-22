package com.trustathanas.absaclone.activities.contactus

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ContactsViewPagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentStatePagerAdapter(fm) {
    private val fragmentList: Array<androidx.fragment.app.Fragment> = arrayOf<androidx.fragment.app.Fragment>(ContactsFragment(), ContactsInterFragment())

    override fun getItem(i: Int): androidx.fragment.app.Fragment {
        return fragmentList[i]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
}