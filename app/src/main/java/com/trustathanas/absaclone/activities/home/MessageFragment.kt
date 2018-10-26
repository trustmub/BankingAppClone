package com.trustathanas.absaclone.activities.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseFragment

class MessageFragment : BaseFragment() {

    override val logTag: String = "Message Fragment"
    override fun getLayout(): Int = R.layout.fragment_message

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }


}
