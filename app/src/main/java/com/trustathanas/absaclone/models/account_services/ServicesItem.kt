package com.trustathanas.absaclone.models.account_services

import com.google.gson.annotations.SerializedName

data class ServicesItem(@SerializedName("name") val name: String = "",
                        @SerializedName("status") val status: String = "")