package com.trustathanas.absaclone.models

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LoginDao {

    @Query("SELECT * FROM login_table WHERE username LIKE :username LIMIT 1")
    abstract fun findByUserName(username: String): LoginModel

    @Query("SELECT * FROM login_table")
    abstract fun getAllUsers(): LiveData<List<LoginModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(user: LoginModel)

    @Query("SELECT * FROM login_table WHERE username LIKE :username LIMIT 1")
    abstract fun getCurrentUser(username: String): LiveData<LoginModel>


}