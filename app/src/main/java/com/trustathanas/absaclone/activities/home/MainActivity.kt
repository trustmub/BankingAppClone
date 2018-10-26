package com.trustathanas.absaclone.activities.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.activities.BaseActivity

class MainActivity : AppCompatActivity() {

//    override val tag: String = "MainActivity"
//    override fun getLayout(): Int = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar_main)
        setSupportActionBar(toolbar)

//        setSupportActionBar(findViewById(R.id.mainToolBar))

        val navigation = Navigation.findNavController(this, R.id.nav_host_fragment)
        setupBottomNavMenu(navigation)
        setupActionBar(navigation)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
}
