package com.trustathanas.absaclone.activities.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseFragment


class HomeFragment : BaseFragment() {

    override val logTag: String
        get() = "Home Fragment"

    override fun getLayout(): Int = R.layout.fragment_home


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(getLayout(), container, false)
    }


}
