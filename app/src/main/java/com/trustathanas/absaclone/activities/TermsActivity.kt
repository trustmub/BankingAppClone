package com.trustathanas.absaclone.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.trustathanas.absaclone.R

class TermsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)
    }

    fun onBackImageClicked(view: View){
        onBackPressed()
    }
}
