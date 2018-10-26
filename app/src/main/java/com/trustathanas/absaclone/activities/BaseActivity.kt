package com.trustathanas.absaclone.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log

abstract class BaseActivity : FragmentActivity() {

    protected abstract val tag: String
    protected abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.v(tag, "[On Create]")
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