package com.trustathanas.absaclone.activities.register

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.trustathanas.absaclone.Adapters.ViewPagerAdapter
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseFragment

class RegisterWelcomeFragment : BaseFragment() {

    override val logTag: String
        get() = "RegisterWelcomeFragment"

    override fun getLayout(): Int = R.layout.register_welcome_fragment


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayout(), container, false)

        val viewPager = view.findViewById<androidx.viewpager.widget.ViewPager>(R.id.view_pager_welcome)
        viewPager.adapter = ViewPagerAdapter(activity!!.supportFragmentManager!!)

        val mRegisterButton = view.findViewById<Button>(R.id.btn_register_for_digital)
        val mLogin = view.findViewById<Button>(R.id.btn_login_register_welcome)

        mRegisterButton.setOnClickListener { v -> Navigation.findNavController(v).navigate(R.id.registerFragment) }

        mLogin.setOnClickListener { v -> Navigation.findNavController(v).navigate(R.id.registerLoginFragment) }

        return view
    }
}


