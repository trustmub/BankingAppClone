package com.trustathanas.absaclone.models

data class LoginResults(val fullname: String, val account: Int, val authToken: String, val accountActive: Boolean)

data class Login(val account: Int,
                 val pin: Int,
                 val user_number: Int)

data class Register(val account: Int,
                    val pin: Int)


