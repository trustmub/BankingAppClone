package com.trustathanas.absaclone.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("user")
                    val user: User,
                    @SerializedName("customer")
                    val customer: Customer)


data class User(@SerializedName("device")
                var device: String = "",
                @SerializedName("account")
                var account: Int = 0,
                @SerializedName("user_number")
                var userNumber: Int = 0)


data class Customer(@SerializedName("account_number")
                    var accountNumber: Int = 0,
                    @SerializedName("account_type")
                    val accountType: String = "",
                    @SerializedName("full_name")
                    val fullName: String = "",
                    @SerializedName("balance")
                    val balance: Int = 0,
                    @SerializedName("email")
                    val email: String = "")


data class AuthResponse(
        @SerializedName("response")
        @Expose
        var response: Response?) {
}


data class RegisterResponse(@SerializedName("response")
                            val response: String)
