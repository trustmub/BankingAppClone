package com.trustathanas.absaclone.utilities

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class SharedPreferencesMain @Inject constructor(private val context: Context) {

    private val PREF_FILE = "AppPreferences"
    private val preferences = context.getSharedPreferences(PREF_FILE, 0)

    private val IS_REGISTERED = "isRegistered"
    private val FULL_NAME = "fullname"
    private val USERNAME = "email"
    private val PASSCODE = "passCode"

    var isRegistered: Boolean
        get() = preferences.getBoolean(IS_REGISTERED, false)
        set(value) = preferences.edit().putBoolean(IS_REGISTERED, value).apply()

    var fullname: String?
        get() = preferences.getString(FULL_NAME, "")
        set(value) = preferences.edit().putString(FULL_NAME, value).apply()

    var username: String?
        get() = preferences.getString(USERNAME, "")
        set(value) = preferences.edit().putString(USERNAME, value).apply()

    var passCode: Int
        get() = preferences.getInt(PASSCODE, 12345)
        set(value) = preferences.edit().putInt(PASSCODE, value).apply()


}