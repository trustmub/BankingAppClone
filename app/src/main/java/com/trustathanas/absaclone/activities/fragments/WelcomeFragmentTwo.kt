package com.trustathanas.absaclone.activities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseFragment

class WelcomeFragmentTwo: BaseFragment() {

    override val logTag: String
        get() = "Welcome Fragment One"

    override fun getLayout(): Int = R.layout.fragment_welcome_two

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }
}