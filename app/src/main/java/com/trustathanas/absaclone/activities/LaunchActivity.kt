package com.trustathanas.absaclone.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.activities.register.RegisterActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (App.prefes.isRegistered) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    /**This activity cannot be restarted, this is t*/
    override fun onRestart() {
        super.onRestart()
        finishAffinity()
    }
}
