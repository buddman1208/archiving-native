package com.samderra.archive.data.remote

import okhttp3.Interceptor
import okhttp3.Response


class ErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        when (response.code) {
            400 -> {
            }
            404 -> {
            }
        }
        return response
    }

}
