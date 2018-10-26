package com.trustathanas.absaclone.activities.contactus


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseFragment

class ContactsFragment : BaseFragment() {

    override val logTag: String
        get() = "Contacts Fragment"

    override fun getLayout(): Int = R.layout.fragment_contacts

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }
}
