package com.trustathanas.absaclone.activities.contactus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseFragment

class ContactsInterFragment : BaseFragment() {
    override val logTag: String = "Contacts international fragment"
    override fun getLayout(): Int = R.layout.fragment_contacts_inter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }
}