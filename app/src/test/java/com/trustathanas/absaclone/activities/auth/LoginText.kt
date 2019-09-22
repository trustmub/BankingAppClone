package com.trustathanas.absaclone.activities.auth

import android.content.Context
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@Config(sdk = [28])
abstract class LoginTest {
    protected fun createContext(): Context {
        return Robolectric.buildActivity(ActivityLogin::class.java).create().get()
    }
}