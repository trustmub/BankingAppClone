package com.trustathanas.absaclone.activities.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trustathanas.absaclone.R

class ProgressDialogFragment : androidx.fragment.app.DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.progress_dalog, container, false)
        view.isPressed = false
        return view
    }
}