package com.trustathanas.absaclone.models.Room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.trustathanas.absaclone.models.LoginDao
import com.trustathanas.absaclone.models.LoginModel

@Database(entities = [LoginModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loginDao(): LoginDao
}