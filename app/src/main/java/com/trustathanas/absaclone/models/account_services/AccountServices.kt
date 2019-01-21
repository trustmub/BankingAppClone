package com.trustathanas.absaclone.models.account_services

import com.google.gson.annotations.SerializedName

data class AccountServices(@SerializedName("response") val response: String = "",
                           @SerializedName("body") val body: Body)