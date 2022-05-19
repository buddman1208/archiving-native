package com.samderra.archive.data.remote

import com.samderra.archive.data.local.pref.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val token = PreferenceManager.userPref.token
        builder.removeHeader("Authorization")
        if (token.isNotEmpty()) {
            builder.addHeader("Authorization", "Bearer $token")
        }
        return chain.proceed(builder.build())
    }
}