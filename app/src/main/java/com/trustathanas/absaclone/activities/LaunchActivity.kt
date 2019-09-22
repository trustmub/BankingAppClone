package com.trustathanas.absaclone.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.activities.auth.ActivityLogin

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //            startActivity(Intent(this, RegisterActivity::class.java))
        if (App.prefes.isRegistered) {
            startActivity(Intent(this, ActivityLogin::class.java))
        } else startActivity(Intent(this, ActivityLogin::class.java))
    }

    /**This activity cannot be restarted, this is t*/
    override fun onRestart() {
        super.onRestart()
        finishAffinity()
    }
}
