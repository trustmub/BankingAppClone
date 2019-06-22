package com.trustathanas.absaclone.activities.auth

class AuthResource<T>(val status: Status, val data: T?, val message: String?) {


    enum class Status {
        AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED
    }

    companion object {

        fun <T> authenticated(data: T?): AuthResource<T> {
            return AuthResource(Status.AUTHENTICATED, data, null)
        }

        fun <T> error(msg: String, data: T?): AuthResource<T> {
            return AuthResource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): AuthResource<T> {
            return AuthResource(Status.LOADING, data, null)
        }

        fun <T> logout(): AuthResource<T> {
            return AuthResource(Status.NOT_AUTHENTICATED, null, null)
        }
    }

}