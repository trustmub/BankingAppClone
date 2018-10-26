package com.trustathanas.absaclone.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "login_table")
data class LoginModel(
        @PrimaryKey(autoGenerate = false)
        val username: String,
        val fullname: String,
        val passCode: Int)

data class PasscodeModel(val number: Int)
