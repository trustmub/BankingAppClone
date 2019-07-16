package com.trustathanas.absaclone.activities.resetaccount

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.trustathanas.absaclone.R
import kotlinx.android.synthetic.main.activity_rest_passcode.*

class ResetPasscodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_passcode)

        btn_reset_passcode.setOnClickListener {
            val resetIntent = Intent(this, ResetActivity::class.java)
            startActivity(resetIntent)
        }

    }

}
