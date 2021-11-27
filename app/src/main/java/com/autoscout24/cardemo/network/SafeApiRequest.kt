package com.autoscout24.cardemo.network

import com.autoscout24.cardemo.util.UNIVERSAL_ERROR_MESSAGE
import retrofit2.Response

open class SafeApiRequest {
    @Throws(ApiException::class)
    suspend fun <T> execute(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        return if (response.isSuccessful) {
            response.body() ?: throw ApiException("Error : Response body is null", response.code())
        } else {
            val errorMessage = response.errorBody()?.string() ?: UNIVERSAL_ERROR_MESSAGE
            throw throw ApiException(errorMessage, response.code())
        }
    }
}
