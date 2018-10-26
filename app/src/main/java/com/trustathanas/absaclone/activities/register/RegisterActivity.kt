package com.trustathanas.absaclone.activities.register

import android.os.Bundle
import androidx.navigation.findNavController
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseActivity

class RegisterActivity : BaseActivity() {

    override val tag: String
        get() = "RegisterActivity"

    override fun getLayout(): Int = R.layout.activity_register

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

//        val navigation = Navigation.findNavController(this, R.id.registration_host_fragment)
//        val navView: NavigationView = NavigationView(this)
//
//        NavigationUI.setupWithNavController(navView, navigation)

    }

//    override fun onSupportNavigateUp() = findNavController(R.id.registration_host_fragment).navigateUp()
}
