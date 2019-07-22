package com.trustathanas.absaclone.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login_table")
data class LoginModel(
        @PrimaryKey(autoGenerate = false)
        val username: String,
        val fullname: String,
        val passCode: Int)

data class PasscodeModel(val number: Int)
