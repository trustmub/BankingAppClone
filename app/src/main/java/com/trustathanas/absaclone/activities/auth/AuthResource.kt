package com.trustathanas.absaclone.activities.auth

class AuthResource<T>(val status: Status, val data: T?, val message: String?) {


    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {

        fun <T> success(data: T?): AuthResource<T> {
            return AuthResource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): AuthResource<T> {
            return AuthResource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): AuthResource<T> {
            return AuthResource(Status.LOADING, data, null)
        }
    }

}