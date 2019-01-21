package com.trustathanas.absaclone.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.trustathanas.absaclone.App
import com.trustathanas.absaclone.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService

class LoginRepository private constructor(private val loginDao: LoginDao, private val executor: ExecutorService) {

    fun addUser(user: LoginModel) {
        executor.execute {
            loginDao.insertUser(user)
        }
    }

    fun getUser(username: String) = loginDao.findByUserName(username)

    fun getAllUsers() = loginDao.getAllUsers()

    fun accessCurrentUser() = loginDao.getCurrentUser(App.prefes.username!!)

    fun login(user: Login): LiveData<AuthResponse> {
        val result: MutableLiveData<AuthResponse> = MutableLiveData()
        App.webServices.login(user).enqueue(LoginCallback(result))
        println("Response in repo, login $result")
        return result
    }

    inner class LoginCallback(val result: MutableLiveData<AuthResponse>) : Callback<AuthResponse> {
        override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
            println("The response failed ${t.message}")

        }

        override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
            println("The response body is ${response.body()}")

            result.value = when {
                response.isSuccessful -> {
                    response.body()
                }
                else -> {
                    response.body()
                }
            }
        }

    }


    companion object {
        @Volatile
        private var instance: LoginRepository? = null

        fun getInstance(loginDao: LoginDao, executor: ExecutorService): LoginRepository =
                instance ?: synchronized(this) {
                    instance ?: LoginRepository(loginDao, executor).also {
                        instance = it
                    }
                }

    }
}


