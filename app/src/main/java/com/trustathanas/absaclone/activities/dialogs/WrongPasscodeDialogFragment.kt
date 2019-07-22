package com.trustathanas.absaclone.activities.dialogs

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trustathanas.absaclone.R

class WrongPasscodeDialogFragment : androidx.fragment.app.DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.wrong_passcode_dialog, container, false)
    }
}