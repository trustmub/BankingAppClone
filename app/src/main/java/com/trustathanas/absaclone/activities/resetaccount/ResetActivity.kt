package com.trustathanas.absaclone.activities.resetaccount

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.trustathanas.absaclone.R
import com.trustathanas.absaclone.R.id.btn_reset_login
import com.trustathanas.absaclone.activities.BaseActivity

class ResetActivity : BaseActivity() {

    override val tag: String = "Reset Activity"
    override fun getLayout(): Int = R.layout.activity_reset

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)

        val resetButton: Button = findViewById<Button>(R.id.btn_reset_login)

        resetButton.setOnClickListener {
            val linkedIntent = Intent(this, LinkDeviceActivity::class.java)
            startActivity(linkedIntent)
        }
    }

    fun onBackImageClickedLogin(view: View) {
        onBackPressed()
    }
}
