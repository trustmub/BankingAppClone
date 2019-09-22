package com.trustathanas.absaclone.activities.home

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.SessionManager
import com.trustathanas.absaclone.activities.auth.AuthResource
import com.trustathanas.absaclone.activities.auth.ActivityLogin
import com.trustathanas.absaclone.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

open class MainActivity : DaggerAppCompatActivity() {


    lateinit var viewmodel: MainViewModel

    @Inject
    lateinit var sessionManager: SessionManager

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory


    val tag: String = "MainActivity"
    fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_main)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        val navigation = Navigation.findNavController(this, R.id.nav_host_fragment)
        setupBottomNavMenu(navigation)
//        setupActionBar(navigation)

        init()
        subscribeObservers()

    }


    private fun init() {
        viewmodel = ViewModelProviders.of(this, providerFactory).get(MainViewModel::class.java)
    }

    private fun subscribeObservers() {

        sessionManager.getAuthUser().observe(this, Observer { responseAuthResource ->
            responseAuthResource?.let { authResource ->
                when (authResource.status) {
                    AuthResource.Status.AUTHENTICATED -> {
                        println("BaseActivity: Authenticated")
                    }
                    AuthResource.Status.LOADING -> {
                        println("BaseActivity: loading")
                    }
                    AuthResource.Status.ERROR -> {
                        println("BaseActivity: Error")
                    }
                    AuthResource.Status.NOT_AUTHENTICATED -> {
                        println("Logged Out")
                        navigateToLogin()
                    }
                }
            }
        })
    }

    private fun navigateToLogin() {
        val intent = Intent(this, ActivityLogin::class.java)
        startActivity(intent)
        finish()

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_logout_item -> {
                println("logout Clicked")
                sessionManager.logout()
//                viewmodel.logoutMain()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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

    override fun onBackPressed() {
        return;
    }

}
