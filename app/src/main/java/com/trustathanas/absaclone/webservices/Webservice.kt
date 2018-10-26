package com.trustathanas.absaclone.webservices

import com.trustathanas.absaclone.utilities.Constants

class Webservice: UserWebInterface {

    override fun login(username: String, passcode: String) {
        println(Constants.BASE_URL)
    }
}