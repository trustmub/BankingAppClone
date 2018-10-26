package com.trustathanas.absaclone.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    protected abstract val logTag: String
    protected abstract fun getLayout(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.v(logTag, "[On CreateView]")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "[On Start]")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "[On Stop]")
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "[On Resume]")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "[On Destroy]")
    }

}