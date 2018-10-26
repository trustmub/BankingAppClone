package <default> (/Users/trustmub/Documents/Development/ABSAclone/app/src/test/java)


import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("user")
                    val user: User,
                    @SerializedName("customer")
                    val customer: Customer)


data class User(@SerializedName("device")
                val device: String = "",
                @SerializedName("account")
                val account: Int = 0,
                @SerializedName("user_number")
                val userNumber: Int = 0)


data class Customer(@SerializedName("account_number")
                    val accountNumber: Int = 0,
                    @SerializedName("account_type")
                    val accountType: String = "",
                    @SerializedName("full_name")
                    val fullName: String = "",
                    @SerializedName("balance")
                    val balance: Int = 0,
                    @SerializedName("email")
                    val email: String = "")


data class AuthResponse(@SerializedName("response")
                        val response: Response)


