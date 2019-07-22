package com.trustathanas.absaclone.models.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.trustathanas.absaclone.models.LoginDao
import com.trustathanas.absaclone.models.LoginModel

@Database(entities = [LoginModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loginDao(): LoginDao
}