package com.trustathanas.absaclone.utilities

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.trustathanas.absaclone.models.LoginDao
import com.trustathanas.absaclone.models.LoginModel

@Database(entities = [LoginModel::class], exportSchema = false, version = 1)
abstract class ApplicationDatabaseInstance : RoomDatabase() {


    abstract fun loginDao(): LoginDao

//    companion object {
//
//        @Volatile
//        var instance: ApplicationDatabaseInstance? = null
//
//        fun getDatabase(context: Context): ApplicationDatabaseInstance? {
//            if (instance == null) {
//                synchronized(ApplicationDatabaseInstance::class.java) {
//                    if (instance == null) {
//                        instance = Room.databaseBuilder(context.applicationContext,
//                                ApplicationDatabaseInstance::class.java, "absa_clone_db")
//                                .build()
//                    }
//                }
//            }
//            return instance
//        }
//    }
}