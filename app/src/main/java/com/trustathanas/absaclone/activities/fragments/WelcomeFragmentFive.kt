package com.trustathanas.absaclone.activities.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseFragment

class WelcomeFragmentFive: BaseFragment() {

    override val logTag: String
        get() = "Welcome Fragment One"

    override fun getLayout(): Int = R.layout.fragment_welcome_five

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }
}