package com.trustathanas.absaclone.repositories

import android.util.Log
import retrofit2.Response
import java.io.IOException

open class BaseResponseWrapper {
    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, error: String): T? {
        val result = mainApiResponse(call, error)
        var output: T? = null
        when (result) {
            is GenericResponse.Success ->
                output = result.output
            is GenericResponse.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output

    }

    private suspend fun <T : Any> mainApiResponse(
            call: suspend () -> Response<T>,
            error: String
    ): GenericResponse<T> {
        val response = call.invoke()
        return if (response.isSuccessful)
            GenericResponse.Success(response.body()!!)
        else
            GenericResponse.Error(IOException("Network Error  $error"))
    }
}
