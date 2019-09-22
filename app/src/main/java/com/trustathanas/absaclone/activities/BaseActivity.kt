package com.trustathanas.absaclone.activities

import androidx.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.trustathanas.absaclone.SessionManager
import com.trustathanas.absaclone.activities.auth.AuthResource
import com.trustathanas.absaclone.activities.auth.ActivityLogin
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {

    protected abstract val tag: String
    protected abstract fun getLayout(): Int

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.v(tag, "BaseActivity: [On Create]")
        subscribeObservers()
    }

    private fun subscribeObservers() {
        sessionManager.getAuthUser().observe(this@BaseActivity, Observer { responseAuthResource ->
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

    override fun onStart() {
        super.onStart()
        Log.d(tag, "[On Start]")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "[On Resume]")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "[On Restart]")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "[On Stop]")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "[On Destroy")
    }
}