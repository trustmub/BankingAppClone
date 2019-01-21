package com.trustathanas.absaclone.models.account_services

import com.google.gson.annotations.SerializedName

data class Body(@SerializedName("card_number") val cardNumber: String = "",
                @SerializedName("count") val count: Int = 0,
                @SerializedName("services") val services: List<ServicesItem>?,
                @SerializedName("account") val account: String = "")